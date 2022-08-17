package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int l;	// 왼쪽 자식 노드
	int r;	// 오른쪽 자식 노드
	public Node (int l, int r) {
		this.l = l;
		this.r = r;
	}
}

public class BOJ_1991_S1_트리순회 {
	
	static Node[] tree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 변수 초기화
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = st.nextToken().toCharArray()[0] - 'A' + 1;
			int l = st.nextToken().toCharArray()[0] - 'A' + 1;
			int r = st.nextToken().toCharArray()[0] - 'A' + 1;
			tree[d] = new Node(l, r);
		}
		
		// 문제 풀이
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		
		// 출력
		System.out.println(sb);
	}
	
	// 전위 순회
	private static void preorder(int i) {
		if (i != '.' - 'A' + 1) {
			sb.append((char) (i - 1 + 'A'));
			preorder(tree[i].l);
			preorder(tree[i].r);
		}
	}
	
	// 중위 순회
	private static void inorder(int i) {
		if (i != '.' - 'A' + 1) {
			inorder(tree[i].l);
			sb.append((char) (i - 1 + 'A'));
			inorder(tree[i].r);
		}
	}
	
	// 후위 순회
	private static void postorder(int i) {
		if (i != '.' - 'A' + 1) {
			postorder(tree[i].l);
			postorder(tree[i].r);
			sb.append((char) (i - 1 + 'A'));
		}
	}
}
