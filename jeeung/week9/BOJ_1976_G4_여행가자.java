import java.io.*;
import java.util.*;

public class BOJ_1976_G4_여행가자 {
    static int n, m;
    static int[][] board;
    static int[] plans;
    static int[] parents;

    static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b)
            parents[b] = a;
        else if (a > b)
            parents[a] = b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    union(i, j);
            }
        }

        plans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        int temp = parents[plans[0] - 1];
        for (int i = 0; i < m; i++) {
            if (temp != parents[plans[i] - 1]) {
                flag = false;
                break;
            }
        }
        if (flag)
            sb.append("YES");
        else
            sb.append("NO");

        System.out.println(sb.toString());

    }
}