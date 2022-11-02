package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_미친로봇 {
    static int[] rangeX = { 0, 0, 1, -1 };
    static int[] rangeY = { 1, -1, 0, 0 };
    static int N;
    static double[] percentages;
    static double ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        percentages = new double[4]; // 동서남북으로 가는 각각의 확률
        for (int i = 0; i < 4; i++) {
            percentages[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        boolean[][] visited = new boolean[30][30];
        visited[15][15] = true;
        DFS(15, 15, visited, 0, 1);

        br.close();
    }

    // 동서남북으로 모든 경우에 대해 탐색.
    public static void DFS(int x, int y, boolean[][] visited, int cnt, double result) {
        if (cnt == N) { // 로봇의 최대 이동 횟수에 도달.
            ans += result; // 지금까지 이동한 방향들의 확률을 더함.
            return;
        }

        // 동서남북 순으로 탐색함.
        for (int i = 0; i < 4; i++) {
            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            if (dx <= 0 || dy <= 0 || dx >= 30 || dy >= 30) {
                continue;
            }

            // 특정 지점을 방문하지 않았을 경우.
            if (!visited[dx][dy]) {
                visited[dx][dy] = true;
                DFS(dx, dy, visited, cnt + 1, result * percentages[i]);
                visited[dx][dy] = false;
            }
        }
    }
}
