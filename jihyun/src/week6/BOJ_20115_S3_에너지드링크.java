package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20115_S3_에너지드링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int max = -1;
		double sum=0;
		for(int i=0;i<n;i++) { //모든 에너지 드링크에 대한 정보를 받으면서
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]>max) //가장 큰 에너지 드링크의 값을 따로 저장한다.
				max=arr[i];
		}
		for(int i=0;i<n;i++) {
			if(arr[i]==max)
				continue;
			sum+=arr[i]*0.5; //가장 큰 에너지 드링크의 값을 제외한 나머지 값들을 절반씩 더한다.
		}
		sum+=max; //마지막에 가장 큰 에너지 드링크의 값을 더한다.
		System.out.println(sum);

	}

}
