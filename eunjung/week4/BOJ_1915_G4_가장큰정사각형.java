package week4;

import java.io.*;
import java.util.*;

public class BOJ_1915_G4_가장큰정사각형 {
	static int n,m,flag;
	static int[][] map;
	static int min = 0,max = 1; // 1*1 정사각형을 기본값으로
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
            	map[i][j] = str.charAt(j)-'0'; // 정수화
                if (map[i][j] == 1) flag = 1; // 
            }
        }
        
        if(flag==0) System.out.println(0); // 1이 없을 경우 0 출력
        
        else {
        	 for (int i = 1; i < n; i++) {
                 for (int j = 1; j < m; j++) {
                     if (map[i][j] == 1) {
                    	 // 바로 위 사각형의 칸이 0이 아닐 경우, 
                         if (map[i - 1][j] != 0 && map[i - 1][j - 1] != 0 && map[i][j - 1] != 0) {
                             min = Math.min(map[i - 1][j], map[i - 1][j - 1]);
                             min = Math.min(min, map[i][j - 1]); // 4개중 최솟값 구함
                             map[i][j] = min + 1; //  현재 칸에 최솟값 + 1
                             max = Math.max(max, map[i][j]);
                             //가장 긴 변의 길이와 현재값 비교해서 max지정
                         }
                     } // dp
                 }
             }
        	 System.out.println(max*max); // 가장 긴 변 * 가장 긴 변 = 가장 큰 넓이
        }
    }
}