package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1991_S1_트리순회 {

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Tree tree = new Tree();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			char parent = tmp[0].charAt(0);
			char left = tmp[1].charAt(0);
			char right = tmp[2].charAt(0);
			tree.addNode(parent, left, right);
		}

		// 풀이 & 출력
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}

	// 트리 본체 생성
	static class Tree {
		Node root;

		// 노드 추가
		public void addNode(char data, char ld, char rd) {

			// 처음에 추가할 때 null이므로 root 초기화
			if (root == null)
				root = new Node(data);

			search(root, data, ld, rd);
		}

		// 노드를 연결하기 위해 root 노드를 찾는다
		public void search(Node root, char data, char ld, char rd) {
			if (root == null)
				return;

			// 찾았으면
			if (root.data == data) {

				// '.' 이 아니면 노드 추가
				if (ld != '.') {
					root.left = new Node(ld);
				}
				if (rd != '.') {
					root.right = new Node(rd);
				}
			} else {
				// 못 찾았으면 계속 탐색
				search(root.left, data, ld, rd);
				search(root.right, data, ld, rd);
			}
		}

		// 전위 순회 > 출력하고 파고 든다
		public void preOrder(Node node) {
			// 자식이 없을 때 까지 계속 재귀
			if (node == null)
				return;

			System.out.print(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}

		// 중위 순회 > 끝까지 파고 들고 한번 빠져 나올 때 출력하고 다시 파고든다.
		public void inOrder(Node node) {
			if (node == null)
				return;

			inOrder(node.left);
			System.out.print(node.data);
			inOrder(node.right);
		}

		// 후위 순회 > 제일 끝까지 파고들어가서 더 이상 자식이 없으면 출력
		public void postOrder(Node node) {
			if (node == null)
				return;

			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data);
		}
	}

	// 노드 본체
	static class Node {
		char data;
		Node left = null;
		Node right = null;

		public Node(char data) {
			super();
			this.data = data;
		}

		public void addLeft(Node n) {
			this.left = n;
		}

		public void addRight(Node n) {
			this.right = n;
		}
	}
}
