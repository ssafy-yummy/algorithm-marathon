package week8;

import java.io.*;
import java.util.*;
 
public class SWEA_1953_모의_탈주범검거 {
	  static int  N,M,R,C,L,map[][];
	    static int v[][];
	    static String[] type = {
	            null,
	            "0312", //1: 상하좌우
	            "03", //2:상하
	            "12", //3:좌우
	            "02", //4:상우
	            "32", //5:하우
	            "31", //6:하좌
	            "01" //7:상좌
	    };
	    static int[] dr = {-1,0,0,1};// 상 0, 좌 1 , 우 2 ,하 3
	    static int[] dc = {0,-1,1,0};
	    static int res;
	     
	    public static void main(String[] args) throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	        int T = Integer.parseInt(st.nextToken());
	        
	        for(int t=1; t<=T; ++t) {
	        	st = new StringTokenizer(br.readLine());
	            N = Integer.parseInt(st.nextToken()); // 행크기
	            M = Integer.parseInt(st.nextToken()); // 열크기
	            R = Integer.parseInt(st.nextToken()); // 맨홀 행   
	            C = Integer.parseInt(st.nextToken()); // 맨홀 열
	            L = Integer.parseInt(st.nextToken()); // 시간
	            map = new int[N][M];
	            v = new int[N][M];
	             
	            for(int i=0; i<N; ++i) {
	            	st = new StringTokenizer(br.readLine());
	                for(int j=0; j<M; ++j) {
	                    map[i][j] = Integer.parseInt(st.nextToken());;
	                }
	            }
	            res = 0;
	            bfs();
	            System.out.println("#"+t+" "+ res);
	        }
	    }
	    private static void bfs() {
	        int time=1;// 맨홀에 처음 있는 시간도 1로 처리해야하므로 cnt=1, 경우의수 result=1
	        Queue<int[]> q = new LinkedList<int[]>();
	        q.offer(new int[] {R,C});
	        v[R][C] = 1;
	        res++;
	         
	        String info = null;
	        
	        while(time++<L) {
	            int size = q.size();
	            while(size-->0) {
	                int[] cur = q.poll();
	                int r = cur[0];
	                int c = cur[1];
	                info = type[map[r][c]];
	                 
	                for(int d = 0, length=info.length(); d < length; ++d) {
	                    int dir = info.charAt(d) - '0';
	                    int nr = r + dr[dir];
	                    int nc = c + dc[dir];
	                     // 터널이 있고 다음 칸이 현 방향과 연결될수 있는 터널일 경우만 
	                    if(check(nr,nc) && map[nr][nc] != 0 && type[map[nr][nc]].contains(Integer.toString(3-dir)) && v[nr][nc] == 0) {
	                        q.offer(new int[] {nr,nc});
	                        v[nr][nc] = 1;
	                        res++;
	                    }
	                }
	            }
	        }
	    }
		private static boolean check(int nr, int nc) {
			return nr>=0 && nr<N && nc>=0 && nc<M ;
		}
}