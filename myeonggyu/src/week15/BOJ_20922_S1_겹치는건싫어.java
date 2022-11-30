package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20922_S1_겹치는건싫어 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int l = 0;
		int r = 0;
		int max = 0;
		HashMap<Integer, Integer> hash = new HashMap<>();
		while(r<n) {
			if(hash.containsKey(arr[r])) {
				
				if(hash.get(arr[r])==k) {
					while(hash.get(arr[r]) == k) {
						hash.put(arr[l], hash.get(arr[l])-1);
						l++;
					}
				}
				else {
					hash.put(arr[r], hash.get(arr[r])+1);
					r++;
				}
			}
			else {
				hash.put(arr[r], 1);
				r++;
			}
			
			max = Math.max(max, r-l);
		}
		
		System.out.println(max);
		
	}

}
