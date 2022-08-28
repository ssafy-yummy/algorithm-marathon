package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915_G4_가장큰정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m+1];
		for(int i=1;i<n+1;i++) {
			String str = br.readLine();
			for(int j=1;j<m+1;j++) {
				map[i][j]=str.charAt(j-1)-'0';
			}
		}
		int[][] sum = new int[n+1][m+1];
		for(int i=1;i<n+1;i++) { //부분합 구하기
			for(int j=1;j<m+1;j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + map[i][j];
			}
		}
//		for(int i=0;i<n+1;i++) {
//			for(int j=0;j<m+1;j++) {
//				System.out.print(sum[i][j]+" ");
//			}
//			System.out.println();
//		}		
		int answer = 0;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(map[i][j]==1) { //색칠되어 있는 칸이면
					int size = 0;
					while(i+size<n+1 && j+size<m+1) { //가로 세로 +1, +2, +3 하면서 가장 큰 정사각형을 찾는다.
						int area = sum[i+size][j+size]-(sum[i+size][j-1]+sum[i-1][j+size]-sum[i-1][j-1]); //가로 세로 size인 사각형의 넓이
						
						if(area==(size+1)*(size+1)) //그 넓이의 합을 비교한다. 즉 모두 1이어서 모두 더한다면 정사각형의 너비 만큼 되는가
							size++;
						else //정사각형이 아니라면 탈출
							break;
					}
					answer = Math.max(answer, size); //지금까지 만들었던 정사각형과 방금 만든 정사각형 중 큰 정사각형을 정답으로
				}
			}
		}
		System.out.println(answer*answer); //정사각형의 넓이

	}

}
