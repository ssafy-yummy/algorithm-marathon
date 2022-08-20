package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992_S1_쿼드트리 {
	static int N; 
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine()); 
		map= new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j]= temp[j] -'0';
			}
		}// end of reading
		
		sb= new StringBuilder();
		sb.append("("); //처음 괄호
		
		dfs(map,0,0,N,N); //로직
		
		
//		for(int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		System.out.println(sb.toString()); //결과 출력
		
	}
	private static void dfs(int [][] array,int x1,int y1, int x2, int y2) {
		
		if(check1(array,x1,y1,x2,y2) ) { //전부 1이면 1추가
			sb.append("1");
			return;
		}else if(check0(array,x1,y1,x2,y2) ) { //전부 0이면 0추가
			sb.append("0");
			return;
		}
		
		if(checkOne(array,x1,y1,x2,y2)) { //4개짜리 사각형 남았을때 들어가는 메서드
			return;
		}
		
		dfs(array,x1,y1,(x1+x2)/2,(y1+y2)/2);//왼쪽 위
		
		dfs(array,x1,(y1+y2)/2,(x1+x2)/2,y2);//오른쪽 위
		
		dfs(array,(x1+x2)/2,y1,x2,(y1+y2)/2);//왼쪽 아래
		
		dfs(array,(x1+x2)/2,(y1+y2)/2,x2,y2);//오른쪽 아래
		
	}
	
	
	private static boolean checkOne(int[][] array, int x1, int y1, int x2, int y2) {
		if(x2-x1==2 && y2-y1==2) {
			sb.append("(");
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					sb.append(array[i][j]);
				}
			}
			sb.append(")");
			return true;
		}
		return false;
	}
	private static boolean check0(int[][] array, int x1, int y1, int x2, int y2) {
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if(array[i][j] !=0)return false;
			}
		}
		return true;
	}
	private static boolean check1(int[][] array, int x1, int y1, int x2, int y2) {
		for (int i = x1; i < x2; i++) {
			for (int j = y1;j < y2; j++) {
				if(array[i][j] !=1)return false;
			}
		}
		return true;
	}

}
