package week11;

import java.io.*;
import java.util.*;

public class BOJ_2573_G4_빙산 {
    static int N, M;
    static int ans = 0;
    static int[][] map;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static boolean[][] visited;
    static class Ice {
        int r, c;
        public Ice(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(arr[i], 0);
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            if (count > 1)
                break;
            else if (count == 0) {
                ans = 0;
                break;
            }
            // count==1 의 경우
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        for (int d = 0; d < 4; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if (check(nr, nc) && map[nr][nc] < 1) {
                                arr[i][j]++;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] -= arr[i][j];
                }
            }
            ans++;
        }

        System.out.println(ans);

    }

    private static void bfs(int r, int c) {
        Queue<Ice> q = new LinkedList<>();
        q.offer(new Ice(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Ice temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = temp.r + dr[d];
                int nc = temp.c + dc[d];

                if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
                    q.offer(new Ice(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}
