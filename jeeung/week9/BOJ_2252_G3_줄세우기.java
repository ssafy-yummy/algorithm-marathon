import java.io.*;
import java.util.*;

public class BOJ_2252_G3_줄세우기 {
    static int v, e;
    static ArrayList<Integer>[] g;
    static int[] indegrees;
    static ArrayList<Integer> arr = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    static void topology() {
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int nextV : g[now]) {
                if (--indegrees[nextV] == 0) {
                    q.add(nextV);
                    arr.add(nextV);
                }
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

        g = new ArrayList[v + 1];
        indegrees = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            indegrees[b]++;
        }

        for (int i = 1; i <= v; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                arr.add(i);
            }

        }

        topology();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append(" ");
        }

        System.out.println(sb.toString());

    }
}