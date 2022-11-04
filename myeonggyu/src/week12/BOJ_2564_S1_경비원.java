package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2564_S1_경비원 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[][] arr = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			
			arr[i] = new int[] {v,Integer.parseInt(st.nextToken())};
			
		}
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int[] my = new int[] {v,Integer.parseInt(st.nextToken())};
		int sums = 0;
		for (int i = 0; i < k; i++) {
			int[] cur = arr[i];
			
			if(cur[0]*my[0] == 2 || cur[0]*my[0] == 12) {//2면 두개가 남북, 12면 두개가 동서
				sums += cal(cur,my,n,m);//반대편 있을 때 거리계산
			}
			else {
				int[] a = make_point(my,n,m);
				int[] b = make_point(arr[i],n,m);
				
				sums += (Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]));
			}
		}
		
		System.out.println(sums);
		
		
	}

	private static int[] make_point(int[] tmp, int n, int m) {
		
		int[] p = new int[2];
		if(tmp[0] == 1)//북
			p = new int[] {0,tmp[1]};
		if(tmp[0]==2)//남
			p = new int[] {n,tmp[1]};
		if(tmp[0]==3)//서
			p = new int[] {tmp[1],0};
		if(tmp[0]==4)//동
			p = new int[] {tmp[1],m};
		return p;
		
	}

	private static int cal(int[] cur, int[] my, int n, int m) {
		int mins = Integer.MAX_VALUE;
		if(cur[0]*my[0] == 2) {//남북이면
			int left = my[1]+cur[1];
			int right = m-my[1] + m-cur[1];
			mins = Math.min(left, right)+n;
		}
		else {
			int up = my[1]+cur[1];
			int down = n-my[1] + m-cur[1];
			mins = Math.min(up, down)+m;
		}
		return mins;
	}

	private static int make_idx(int v, int n, int m) {
		int idx = 0;
		if(v == 1)//북쪽 == 0
			idx = 0;
		if(v == 2)//남쪽
			idx = n-1;
		if(v == 3)//서쪽
			idx = 0;
		if(v == 4)//동쪽
			idx = m-1;
		
		return idx;
	}

}