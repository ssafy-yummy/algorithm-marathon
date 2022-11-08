package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_D4_수영대회결승전 {
   static class Pos{
       int x,y;

       public Pos(int x, int y) {
           super();
           this.x = x;
           this.y = y;
       }
        
   }
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = null;
       int T = Integer.parseInt(br.readLine());
        
       for(int tc=1;tc<=T;tc++) {
            
           int n = Integer.parseInt(br.readLine());
           int[][] map = new int[n][n];
            
           for(int i=0;i<n;i++) { //맵 입력 받음
               st = new StringTokenizer(br.readLine()," ");
               for(int j=0;j<n;j++) {
                   map[i][j]=Integer.parseInt(st.nextToken());
               }
           }
           st = new StringTokenizer(br.readLine()," ");
           Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
           st = new StringTokenizer(br.readLine()," ");
           Pos end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
           int[] dx = {-1,1,0,0};
           int[] dy = {0,0,-1,1};
           Queue<Pos> queue = new LinkedList<>();
           queue.offer(start);
           int[][] visit = new int[n][n];
           for(int i=0;i<n;i++) { //모든 칸을 최대값으로 설정함
               for(int j=0;j<n;j++) {
                   visit[i][j]=Integer.MAX_VALUE;
               }
           }
           visit[start.x][start.y]=0; //시작점은 0
            
           int answer = -1;
            
           while(!queue.isEmpty()) {
               Pos p = queue.poll();
               int x = p.x;
               int y = p.y;
               if(x==end.x && y==end.y) { //도착점 도달
                   answer = visit[x][y]; //최소값 저장
                   break;
               }
               for(int d=0;d<4;d++) { //사방탐색
                   int nx = x+dx[d];
                   int ny = y+dy[d];
                    
                   if(nx<0 || nx>=n || ny<0 || ny>=n) //수영장 벗어나면 안됨
                       continue;

                   if(map[nx][ny]==1) //장애물 안됨
                       continue;
                    
                   int temp;
                   if(map[nx][ny]==2) { //소용돌이가 존재하면
                       temp = visit[x][y]+(3-visit[x][y]%3); //소용돌이가 없어질때까지 대기한 시간 포함
                   }
                   else { //일반 칸이면
                       temp = visit[x][y]+1; //1초 증가
                   }
                   if(visit[nx][ny]>temp) { //해당 칸을 더 빨리 방문한 적이 없다면
                       visit[nx][ny]=temp; //최소값 갱신
                       queue.offer(new Pos(nx,ny)); //큐에 추가
                   }
            
               }
           }
                    
           System.out.printf("#%d %d\n",tc, answer);
       }
        
   }
}
