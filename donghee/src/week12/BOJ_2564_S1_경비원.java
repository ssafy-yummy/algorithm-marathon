package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2564_S1_경비원 {
	
	static int N,M,map[][],K,result;
	static int[] dong;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		M= Integer.parseInt(st.nextToken()); //가로
		N= Integer.parseInt(st.nextToken()); //세로
		
		dong = new int[2];
		list =new ArrayList<>();
		
		K= Integer.parseInt(br.readLine());
		int direct= -1;
		int dist=-1;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			direct = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			int[] temp = new int[2];
			temp[0]= direct ==1? 0: direct== 2? N:direct==3? dist:direct==4?  dist:-1;
			temp[1]= direct ==1? dist:direct==2? dist: direct==3? 0: direct==4? M:-1;
			list.add(temp);
		}
		st = new StringTokenizer(br.readLine());
		direct = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(st.nextToken());
		
		dong[0]= direct ==1? 0: direct== 2? N:direct==3? dist:direct==4?  dist:-1;
		dong[1]= direct ==1? dist:direct==2? dist: direct==3? 0: direct==4? M:-1;
		
		for (int i = 0; i < list.size(); i++) {
			int d = Integer.MAX_VALUE;
			int[] tmp = list.get(i);
			if((dong[0]==0 && tmp[0]==0) || (dong[0]==N && tmp[0]==N)) { // 위나 아래줄
				d = Math.abs(dong[1]-tmp[1]); 
			}else if((dong[1]==0 && tmp[1]==0) || (dong[1]==M && tmp[1]==M)) { // 양 옆줄 같이
				d = Math.abs(dong[0]-tmp[0]);
			}else if(Math.abs(dong[0]-tmp[0])==N || Math.abs(dong[1]-tmp[1])==M){ //평행
				//1. 위아래
				if(Math.abs(dong[0]-tmp[0])==N) {
					d= Math.min(tmp[1]+dong[1]+N, M-tmp[1] + M-dong[1] + N);
				}
				//2. 양옆
				else {
					d= Math.min(tmp[0]+dong[0]+M, N-tmp[0]+ N-dong[0] + M);
				}
			}else { //수직
				d= Math.abs(tmp[0]-dong[0])+ Math.abs(tmp[1]-dong[1]);
			}
			
			result +=d;
		}
		System.out.println(result);
	}

}
