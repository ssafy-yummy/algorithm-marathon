package week15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class PG_연습문제_LV2_전력망을둘로나누기 {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int answer;

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        adj = new ArrayList[n + 1];

        for (int x = 0; x < n - 1; x++) {

            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            visited = new boolean[n + 1];

            for (int i = 0; i < n - 1; i++) {
                if (x == i)
                    continue;
                int s = wires[i][0];
                int e = wires[i][1];

                adj[s].add(e);
                adj[e].add(s);
            }

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i])
                    tmp.add(bfs(i));
            }

            answer = Math.min(answer, Math.abs(tmp.get(0) - tmp.get(1)));

        }

        return answer;
    }

    private int bfs(int start) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                if (!visited[adj[now].get(i)]) {
                    visited[adj[now].get(i)] = true;
                    q.offer(adj[now].get(i));
                    cnt++;
                }
            }
        }

        return cnt;
    }
}