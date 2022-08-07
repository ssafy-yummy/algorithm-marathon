package week1;

import java.io.*;
import java.util.*;

public class BOJ_2667_S1_단지번호붙이기 {
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    static int countNum = 0;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){ // 단지가 있으면서 방문하지 않았을 경우
                	countNum = 0; // countNum 초기화
                    dfs(i,j); // dfs 호출
                    result.add(countNum); // 리스트에 추가
                }
            }
        }
        System.out.println(result.size()); // 리스트 size 출력
        Collections.sort(result); // 오름차순 정렬

        for(int i : result){
            System.out.println(i);
        }
    }

    private static void dfs(int r, int c) {
    	countNum++; // 단지 수 증가
        visited[r][c] = true; // 방문으로 바꿈
        
        // 4방 탐색
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            // 범위내의 인덱스면서
            if(check(nr,nc)){
            	// 단지 있고 && 미방문일시
                if(map[nr][nc] == 1 && !visited[nr][nc]){
                    dfs(nr,nc);
                }
            }
        }
    }
    private static boolean check(int r, int c) {
    	return r>=0 && c >=0 && r < N && c < N ;
    }
}