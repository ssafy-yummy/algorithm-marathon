package week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class SWEA_2105_모의_디저트카페 {
    static int[] dx = { 1, 1, -1, -1 };
    static int[] dy = { 1, -1, -1, 1 };
    static int n;
    static int[][] map;
    static int answer;
    static int a,b;
    static Set<Integer> set;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            answer = -1;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    set.add(map[i][j]); //시작하는 디저트
                    a=i;
                    b=j;
                    dfs(i,j,0);
                    set.remove(map[i][j]);
                }
            }
 
            System.out.printf("#%d %d\n", tc, answer);
 
        }
 
    }
 
    private static void dfs(int x, int y, int dir) {
         
         
        for(int d=dir;d<4;d++) { //현재 방향 이상으로만 갈 수 있다.
            int nx=x+dx[d];
            int ny=y+dy[d];
             
            if(nx<0 || nx>=n || ny<0 || ny>=n) //맵을 벗어난다
                continue;
             
            if(nx==a && ny==b && set.size()>=3) { //처음 시작한 자리로 돌아온다. d=3이라고 안되는 이유는 왔다가 다시 돌아오는 경우
                answer=Math.max(answer, set.size()); //디저트 수 갱신
                return;
            }
             
            if(set.contains(map[nx][ny])) //이미 방문한 곳
                continue;
             
            set.add(map[nx][ny]); //디저트 추가
            dfs(nx,ny,d);
            set.remove(map[nx][ny]); //디저트 삭제
        }
         
    }
 
}
