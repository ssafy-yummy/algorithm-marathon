import java.io.*;
import java.util.*;

public class BOJ_7576_G5_토마토 {

    static int n, m;
    static int[][] board;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int maxVal;

    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1)
                    q.add(new Integer[] { i, j });
            }
        }

        while (!q.isEmpty()) {
            Integer[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!(0 <= nx && nx < n && 0 <= ny && ny < m))
                    continue;

                if (board[nx][ny] != 0)
                    continue;

                board[nx][ny] = board[x][y] + 1;
                q.add(new Integer[] { nx, ny });
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        boolean flag = true;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i][j] == 0)
                    flag = false;
                maxVal = Math.max(maxVal, board[i][j]);
            }
        }

        if (flag)
            sb.append(maxVal - 1);
        else
            sb.append(-1);

        System.out.println(sb.toString());

    }
}