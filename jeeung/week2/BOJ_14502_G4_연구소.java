import java.util.*;
import java.io.File;

public class BOJ_14502_G4_연구소 {

    static int[][] board;
    static int n, m;
    static int maxVal;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static void bfs() {
        int[][] newBoard = new int[m][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                newBoard[x][y] = board[x][y];
            }
        }

        Queue<Integer[]> q = new LinkedList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (newBoard[x][y] == 2)
                    q.add(new Integer[] { x, y });
            }
        }

        while (!q.isEmpty()) {
            Integer[] xy = q.poll();

            int x = xy[0], y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (newBoard[nx][ny] == 0) {
                        q.offer(new Integer[] { nx, ny });
                        newBoard[nx][ny] = 2;
                    }
                }
            }

        }

        int count = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (newBoard[x][y] == 0)
                    count++;
            }
        }

        // for (int y = 0; y < n; y++) {
        // for (int x = 0; x < m; x++) {
        // System.out.print(newBoard[x][y]);
        // }
        // System.out.println();
        // }
        // System.out.println();

        maxVal = Math.max(maxVal, count);
    }

    static void backtrack(int wall) {
        if (wall == 0) {
            bfs();
            return;
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[x][y] == 0) {
                    board[x][y] = 1;
                    backtrack(wall - 1);
                    board[x][y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[m][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                board[x][y] = sc.nextInt();
            }
        }

        backtrack(3);
        System.out.println(maxVal);

    }
}