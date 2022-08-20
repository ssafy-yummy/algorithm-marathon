import java.io.*;
import java.util.*;

public class BOJ_14889_S2_스타트와링크 {

    static int n;
    static int[][] board;
    static int[] groupA;
    static int[] groupB;
    static int minVal;

    static int getSum(int idx, int[] tempA, int[] tempB) {
        int sum = 0;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                sum += board[groupA[i]][groupA[j]] + board[groupA[j]][groupA[i]];
                sum -= board[groupB[i]][groupB[j]] + board[groupB[j]][groupB[i]];
                // System.out.println(groupB[i] + " " + groupA[j]+ " " + groupB[i] + " " +
                // groupB[j]);
            }
        }

        return Math.abs(sum);
    }

    static void backtrack(int idx, int cnt, int r) {
        if (cnt == r) {

            int countA = 0;
            int countB = 0;
            for (int i = 0; i < n; i++) {
                if (countA < n / 2 && groupA[countA] == i) {
                    countA++;
                } else {
                    groupB[countB++] = i;
                }
            }
            minVal = Math.min(minVal, getSum(0, groupA, groupB));

            return;
        }

        for (int i = idx; i < n; i++) {
            groupA[cnt] = i;
            backtrack(i + 1, cnt + 1, r);
            groupA[cnt] = 0;
        }

    }

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        minVal = Integer.MAX_VALUE;
        groupA = new int[n / 2];
        groupB = new int[n / 2];

        board = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0, n / 2);
        sb.append(minVal);

        System.out.println(sb.toString());

    }
}