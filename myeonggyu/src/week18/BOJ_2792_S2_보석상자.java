package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2792_S2_보석상자 {

	static int n;
	static int m;
	static int[] colors;
	static int res = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		colors = new int[m];
		int maxs = 0;
		for (int i = 0; i < m; i++) {
			colors[i] = Integer.parseInt(br.readLine());
			maxs = Math.max(maxs, colors[i]);
		}
		
		Arrays.sort(colors);
		
		binarySearch(0,maxs);
		System.out.println(res);

		
	}

	private static void binarySearch(int left,int right) {

		
		
		int mid = (right+left)/2;
		
		if(mid==left) {
			
			if(left==0)
			{
				res = right;
				return;
			}
			
			if(isPossible(left))
				res = left;
			else
				res=right;
			return;
		}
		
		
		
		if(isPossible(mid))
			binarySearch(left, mid);
		else
			binarySearch(mid, right);
		
	}

	private static boolean isPossible(int mid) {
		int cnt = 0;
		for (int i = m-1; i >= 0; i--) {
			int c = colors[i];
			
			if(c<=mid)
				break;
			
			int v = c%mid==0 ? 0 : 1;
			v += c/mid;
			
			if(cnt+v+m-1 > n)
				return false;
			cnt+=(v-1);
		}
		return true;
	}

}
