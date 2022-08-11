import java.util.*;
import java.io.File;

public class BOJ_1992_S1_쿼드트리 {

    static int[][] board;

    static void dfs(int sx, int sy, int n) {
        if (n == 0)
            return;

        int now = board[sx][sy];

        boolean flag = true;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (now != board[x + sx][y + sy])
                    flag = false;
            }
        }

        if (flag) {
            System.out.print(now - '0');
            return;
        }

        System.out.print("(");
        dfs(sx, sy, n / 2);
        dfs(sx, sy + n / 2, n / 2);
        dfs(sx + n / 2, sy, n / 2);
        dfs(sx + n / 2, sy + n / 2, n / 2);
        System.out.print(")");

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] s = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = s[j];
            }
        }
        dfs(0, 0, n);
    }
}