import java.io.*;
import java.util.*;

public class BOJ_1916_G5_최소비용구하기 {
    static int v, e;
    static int start, end;
    static ArrayList<Integer[]>[] g;
    static int[] distance;

    static int dijkstra() {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new Integer[] { 0, start });
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Integer[] temp = pq.poll();
            int cost = temp[0];
            int now = temp[1];

            if (distance[now] < cost)
                continue;

            for (Integer[] nextV : g[now]) {
                int nextCost = cost + nextV[1];
                if (nextCost < distance[nextV[0]]) {
                    distance[nextV[0]] = nextCost;
                    pq.add(new Integer[] { nextCost, nextV[0] });
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        g = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Integer[] { b, c });
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        distance = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        sb.append(dijkstra());

        // System.out.println(Arrays.toString(distance));

        System.out.println(sb.toString());

    }
}
