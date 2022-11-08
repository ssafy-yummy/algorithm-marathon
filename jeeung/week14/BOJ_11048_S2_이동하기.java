import java.util.*;
import java.io.*;

public class BOJ_11048_S2_이동하기 {

    static int n, m;
    static int[][] board, sumBoard;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        sumBoard = new int[m][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0 && j == 0)
                    sumBoard[i][j] = board[i][j];
                else if (i == 0)
                    sumBoard[i][j] = board[i][j] + sumBoard[i][j - 1];
                else if (j == 0)
                    sumBoard[i][j] = board[i][j] + sumBoard[i - 1][j];
                else
                    sumBoard[i][j] = board[i][j] +
                            Math.max(sumBoard[i][j - 1], Math.max(sumBoard[i - 1][j], sumBoard[i - 1][j - 1]));
            }
        }
        System.out.println(sumBoard[m - 1][n - 1]);
    }
}