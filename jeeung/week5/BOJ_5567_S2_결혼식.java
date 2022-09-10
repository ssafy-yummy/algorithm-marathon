import java.io.*;
import java.util.*;

public class BOJ_5567_S2_결혼식 {

    static int v, e, k, x;
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static int count;
    static ArrayList<Integer> result = new ArrayList<>();

    static void bfs(int s) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] { s, 0 });

        visited[s] = true;

        while (!q.isEmpty()) {
            Integer[] temp = q.poll();
            int now = temp[0], cost = temp[1];

            if (cost == k) {
                result.add(now);
            }

            for (Integer nextV : g[now]) {
                if (visited[nextV])
                    continue;

                visited[nextV] = true;
                q.add(new Integer[] { nextV, cost + 1 });
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visited = new boolean[v + 1];

        g = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
        }

        count = 0;

        bfs(x);

        result.sort((a, b) -> a - b);
        if (result.size() == 0)
            sb.append(-1);
        else {
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i) + "\n");
            }
        }

        System.out.println(sb.toString());

    }
}