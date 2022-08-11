package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr1 = new int[n];
		for(int i=0;i<n;i++) {
			arr1[i]=Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int[] arr2 = new int[m];
		for(int i=0;i<m;i++) {
			arr2[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1); //비교할 첫번째 배열을 오름차순으로 정렬한다. 
		for(int i=0;i<arr2.length;i++) {
			int answer=0; //기본은 존재하지 않는다. 
			//이분탐색 코드
			int left=0;
			int right=n-1;
			while(left<=right) { //절반을 기준으로 왼쪽or오른쪽 탐색할 구간을 정한다.
				int mid=((left+right)/2);
				if(arr2[i]>arr1[mid])
					left=mid+1;
				else if(arr2[i]<arr1[mid])
					right=mid-1;
				else {
					answer=1;
					break;
				}		
			}
			
			System.out.println(answer);
		}
	}
}
