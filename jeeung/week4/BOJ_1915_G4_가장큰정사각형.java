import java.io.*;
import java.util.*;

public class BOJ_1915_G4_가장큰정사각형 {

    static int n, m;
    static char[][] board;
    static int[][] newBoard;

    static int maxDia;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[m][n];
        newBoard = new int[m][n];
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[j][i] = temp[j];
            }
        }

        for (int x = 0; x < m; x++) {
            if (board[x][0] == '1') {
                newBoard[x][0] = 1;
                maxDia = 1;
            }
        }

        for (int y = 0; y < n; y++) {
            if (board[0][y] == '1') {
                newBoard[0][y] = 1;
                maxDia = 1;
            }
        }

        // 이전 대각선에 유효한 정사각형의 지름을 적어놓음
        // 새로 추가되는 가로, 세로가 이전 대각선 값까지 유효하다면 추가된 값을 적어놓기
        // 아니라면 유효한 값까지만 추가하기
        for (int y = 1; y < n; y++) {
            for (int x = 1; x < m; x++) {
                int valid_dia = 0;
                for (int dia = 0; dia < newBoard[x - 1][y - 1] + 1; dia++) {
                    if (board[x - dia][y] != '1' || board[x][y - dia] != '1')
                        break;
                    valid_dia++;
                }
                newBoard[x][y] = valid_dia;
                maxDia = Math.max(maxDia, valid_dia);
            }
        }

        sb.append(maxDia * maxDia);

        System.out.println(sb.toString());

    }
}