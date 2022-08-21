package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_S1_트리순회 {

	static Node head; //root
	
	static class Node{ //노드는 value와 왼쪽 오른쪽 노드로 구성된다.
		char v;
		Node left,right;

		public Node(char v) {
			this.v = v;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		head = new Node('A');
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			char v = st.nextToken().charAt(0);
			char left_v = st.nextToken().charAt(0);
			char right_v = st.nextToken().charAt(0);
			InsertNode(head, v,left_v,right_v);
		}
		recursion1(head);
		System.out.println();
		recursion2(head);
		System.out.println();
		recursion3(head);
	}

	private static void InsertNode(Node head, char v, char left_v, char right_v) {	
		if(head.v == v) { //자기 값(삽입하고자 하는 위치)을 찾았을 때, 자식이 있다면 추가해준다.
			if(left_v!='.')
				head.left = new Node(left_v);
			if(right_v!='.')
				head.right = new Node(right_v);
		}
		else { //자기 값(삽입하고자 하는 위치)를 찾기 위해 자식 트리를 탐색한다. 
			if(head.left !=null)
				InsertNode(head.left, v, left_v, right_v);
			if(head.right !=null)
				InsertNode(head.right, v, left_v, right_v);
		}
	}
	
	private static void recursion1(Node head) {
		if(head==null)
			return;
		System.out.print(head.v);
		recursion1(head.left);
		recursion1(head.right);
	}
	
	private static void recursion2(Node head) {
		if(head==null)
			return;
		recursion2(head.left);
		System.out.print(head.v);
		recursion2(head.right);
	}
	
	private static void recursion3(Node head) {
		if(head==null)
			return;
		recursion3(head.left);
		recursion3(head.right);
		System.out.print(head.v);
	}

}
