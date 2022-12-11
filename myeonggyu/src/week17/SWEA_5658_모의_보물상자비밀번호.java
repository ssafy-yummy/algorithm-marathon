package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_5658_모의_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			ArrayList<String> arr = new ArrayList<>();
			String[] tmp = br.readLine().split("");
			for (int i = 0; i < n; i++) {
				arr.add(tmp[i]);
			}
			
			HashSet<Integer> hash = new HashSet<>();
			
			
			int rotateCnt = n/4;
			
			for (int i = 0; i < rotateCnt; i++) {
				
				//회전전에 일단 넣어
				for (int j = 0; j < 4; j++) {
					StringBuilder sb = new StringBuilder();
					for (int ii = 0; ii < rotateCnt; ii++) {						
						sb.append(arr.get(ii+(j*rotateCnt)));
					}
					hash.add(Integer.parseInt(sb.toString(),16));
				}
				
				//회전시켜
				arr.add(0,arr.get(n-1));
				arr.remove(arr.size()-1);
			}
		
			int[] res = new int[hash.size()];
			int idx = 0;
			for (Integer i : hash) {
				res[idx] = i;
				idx++;
			}
			
			Arrays.sort(res);
			System.out.println("#" + t + " "+res[hash.size()-k]);
		
		}
		
	}

}
