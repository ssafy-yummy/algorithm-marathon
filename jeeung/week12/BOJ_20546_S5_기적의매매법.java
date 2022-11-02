import java.io.*;
import java.util.*;

public class BOJ_20546_S5_기적의매매법 {

    static int n;
    static int[] dir, dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };
    static int[][] board, visited;
    static double ans;

    static void dfs(int x, int y, double val, int level) {
        if (level == n) {
            ans += val;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (visited[nx][ny] == 1)
                continue;

            visited[nx][ny] = 1;
            dfs(nx, ny, val * dir[i] / 100, level + 1);
            visited[nx][ny] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dir = new int[4];
        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        visited = new int[2 * n + 1][2 * n + 1];
        visited[n][n] = 1;
        dfs(n, n, 1, 0);

        sb.append(ans);
        System.out.println(sb.toString());

    }
}
