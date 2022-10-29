import java.io.*;
import java.util.*;

public class BOJ_2573_G4_빙산 {
    static int n, m, age;
    static int[][] board, visited, meltBoard;
    static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

    static void resetBoard(int[][] _board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                _board[i][j] = 0;
            }
        }
    }

    static void dfs(int x, int y) {
        if (!(0 <= x && x < n && 0 <= y && y < m))
            return;

        if (board[x][y] == 0)
            return;

        if (visited[x][y] == 1)
            return;

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    static void isSep() {
        int count = 0;
        resetBoard(visited);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && board[i][j] != 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        if (count == 0) {
            System.out.println(0);
            System.exit(0);
        }

        if (count > 1) {
            System.out.println(age);
            System.exit(0);
        }
    }

    static void melt() {
        resetBoard(meltBoard);

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (board[x][y] != 0 && board[nx][ny] == 0)
                            meltBoard[x][y]++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = Math.max(0, board[i][j] - meltBoard[i][j]);
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
        visited = new int[n][m];
        meltBoard = new int[n][m];
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                board[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            isSep();
            melt();
            age++;
        }
    }
}