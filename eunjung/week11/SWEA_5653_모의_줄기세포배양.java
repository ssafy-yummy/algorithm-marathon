package week11;

import java.io.*;
import java.util.*;
 
public class SWEA_5653_모의_줄기세포배양 {
    static int N,M,R,C,result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int K; // 배양시간
    static int X; // 생명력
    static ArrayList<Cell> l = new ArrayList<>();
     
    static class Cell implements Comparable<Cell>{
        int r,c,x,xx;
        boolean live;
        public Cell(int r, int c, int x, int xx, boolean live) {
            this.r = r;
            this.c = c;
            this.x = x;
            this.xx = xx;
            this.live = live;
        }
        @Override
        public int compareTo(Cell o) {
            return o.xx-this.xx;
        }
    }
    public static void main(String[] args) throws IOException {
        // 각 줄기세포 생명력 가짐
        // 초기 상태에서 줄기 세포들은 비활성 상태
        // 생명력 수치가 X인 줄기 세포의 경우 X시간 동안 비활성 상태이고 X시간이 지나는 순간 활성 상태
        // 줄기 세포가 활성 상태가 되면 X시간 동안 살아있을 수 있으며 X시간이 지나면 세포는 죽게 된
        // 동시 번식하려고 하는 경우 생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 혼자서 차지하게 된다
        // K시간 후 살아있는 줄기 세포(비활성 상태 + 활성 상태)의 총 개수를 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            R = N+K*2+4;
            C = M+K*2+4;
            map = new int[R][C];
            visited = new boolean[R][C];
             
            for (int i = R/2 ; i < R/2+N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = C/2; j < C/2+M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]!=0) {
                        l.add(new Cell(i,j,map[i][j],map[i][j],false));
                        visited[i][j] = true;
                    }
                }
            }
            for (int i = 0; i < K; i++) {
                spread();
            }
            System.out.println("#"+t+" "+l.size());
            l.clear();
        }
    }
     
    private static void spread() {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
         
        for (int i = 0; i < l.size(); i++) {
            Cell cur = l.get(i);
            pq.offer(new Cell(cur.r,cur.c,cur.x,cur.xx,cur.live));
        }
         
        l.clear();
         
        while(!pq.isEmpty()) {
            Cell cur = pq.poll();
 
            if(!cur.live) {
                cur.xx--;
                if(cur.xx==0) {
                    l.add(new Cell(cur.r, cur.c, cur.x, cur.x, true));
                }
                else {
                    l.add(new Cell(cur.r, cur.c, cur.x, cur.xx, false));
                }
            }
             
            else {
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r+dr[d];
                    int nc = cur.c+dc[d];
                     
                    if(check(nr,nc) && !visited[nr][nc]) {
                        l.add(new Cell(nr,nc,cur.xx,cur.xx,false));
                        visited[nr][nc] = true;
                    }
                }
                cur.xx--;
                if(cur.xx==0) continue;
                else {
                    l.add(new Cell(cur.r, cur.c, cur.x, cur.xx, true));
                }
            }
        }
    }
     
    private static boolean check(int nr, int nc) {
        return nr>=0 && nr<R && nc>=0 && nc<C;
    }
}