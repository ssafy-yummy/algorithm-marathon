import java.io.*;
import java.util.*;

public class BOJ_3184_S1_양 {

    static int r, c;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static int v, o, total_v, total_o;

    static void dfs(int x, int y) {
        if (!(0 <= x && x < c && 0 <= y && y < r))
            return;

        if (visited[x][y])
            return;

        visited[x][y] = true;

        if (board[x][y] == '#')
            return;

        if (board[x][y] == 'o')
            o++;
        else if (board[x][y] == 'v')
            v++;

        board[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[c][r];
        visited = new boolean[c][r];

        for (int i = 0; i < r; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                board[j][i] = temp[j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                v = 0;
                o = 0;
                if (board[j][i] != '#' && visited[j][i] == false) {
                    dfs(j, i);
                }
                if (o > v)
                    total_o += o;
                else
                    total_v += v;
            }
        }

        sb.append(total_o + " " + total_v);
        System.out.println(sb.toString());

    }
};