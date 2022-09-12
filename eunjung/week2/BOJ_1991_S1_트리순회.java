package Study;

import java.io.*;
import java.util.*;

public class BOJ_1991_S1_트리순회 {
	static int N;
	static Map<Character, char[]> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char[] node = str.toCharArray();
			
			// 부모노드와 양쪽 자식노드 입력받음
			map.put(node[0], new char[] {node[2], node[4]});
		}

		preOrder('A'); // 전위순회
		System.out.println();
		inOrder('A'); // 중위순회
		System.out.println();
		postOrder('A'); // 후위순회
	}
	
	private static void preOrder(char c) {	
		char[] node = map.get(c);
		
		System.out.print(c); // 전위순회
		// 자식노드가 있을경우 recursion
		if(node[0] != '.') preOrder(node[0]);
		if(node[1] != '.') preOrder(node[1]);
	}
	
	private static void inOrder(char c) {
		char[] node = map.get(c);
		
		if(node[0] != '.') inOrder(node[0]);
		System.out.print(c); // 중위순회
		if(node[1] != '.') inOrder(node[1]);
	}
	
	private static void postOrder(char c) {
		char[] node = map.get(c);
		
		if(node[0] != '.') postOrder(node[0]);
		if(node[1] != '.') postOrder(node[1]);
		System.out.print(c); // 후위순회
	}
}