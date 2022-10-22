package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[m];
		for(int i=0;i<m;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		
		/*
		0 0 0 1 0 0 1 0 0 0 0 1 0 0 (arr[j]>=i 인 경우는 1로, 아니면 0으로)
		j가 2일때 유효벽이 세워지고  count는 2, 4가 더해짐.
		*/
		
		for(int i=1;i<=n;i++) { //1층부터 n층까지 확인
			boolean flag = false; //유효 벽 확인 용 flag
			int count = 0;
			for(int j=0;j<m;j++) { //0~m번째 칸까지
				if(arr[j]>=i) { //j번째 칸의 벽 높이가 i층 이상이면 
					if(flag==true) { //유효벽 존재 할 경우
						answer+=count; //count를 더해지고
					}
					else { //지금까지 유효벽이 존재 하지 않았다
						flag = true; //유효 벽 세우기
					}
					count = 0;
				}
				else { //빗물이 찰 수 있는 공간 
					count++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
