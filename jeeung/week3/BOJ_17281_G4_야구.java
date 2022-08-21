import java.io.*;
import java.util.*;

public class BOJ_17281_G4_야구 {

    static int n;
    static int[][] board;
    static boolean[] visited = new boolean[8];
    static int[] nums = new int[8];
    static int maxScore;

    static int[] maxP = new int[9];
    static int[] maxBoard = new int[9];

    static void process(int[] p) {
        int idx = 0;
        int score = 0;
        for (int inning = 0; inning < n; inning++) {
            int b1 = 0, b2 = 0, b3 = 0;
            int outCount = 0;
            while (outCount < 3) {
                if (board[inning][p[idx]] == 0) {
                    outCount++;
                } else if (board[inning][p[idx]] == 1) {
                    score += b3;
                    b3 = b2;
                    b2 = b1;
                    b1 = 1;
                } else if (board[inning][p[idx]] == 2) {
                    score += b3 + b2;
                    b3 = b1;
                    b2 = 1;
                    b1 = 0;
                } else if (board[inning][p[idx]] == 3) {
                    score += b3 + b2 + b1;
                    b3 = 1;
                    b2 = 0;
                    b1 = 0;
                } else if (board[inning][p[idx]] == 4) {
                    score += b3 + b2 + b1 + 1;
                    b1 = 0;
                    b2 = 0;
                    b3 = 0;
                }

                idx = (idx + 1) % 9;
            }
        }
        maxScore = Math.max(maxScore, score);
    }

    static void perm(int idx) {
        if (idx == 8) {
            int[] p = new int[9];

            for (int i = 0; i < 3; i++)
                p[i] = nums[i] + 1;
            p[3] = 0;
            for (int i = 3; i < 8; i++)
                p[i + 1] = nums[i] + 1;

            process(p);

            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            nums[idx] = i;
            perm(idx + 1);
            nums[idx] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n][9];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);

        sb.append(maxScore);

        System.out.println(sb.toString());

    }
}