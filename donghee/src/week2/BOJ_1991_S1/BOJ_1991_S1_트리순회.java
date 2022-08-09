package week2.BOJ_1991_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	char data; //노드에 들어갈 데이터
	Node left; //그 노드의 왼쪽 노드
	Node right;//그 노드의 오른쪽 노드

	public Node(char data) { //생성자
		this.data = data;
	}
}

class Tree { //트리 구현
	Node root; //루트 노드 'A'

	public void createNode(char data, char leftNode, char rightNode) {
		if (root == null) {//루트 노드가 없다면, 즉 루트 노드 생성때만
			root = new Node(data);

			if (leftNode != '.') {
				root.left = new Node(leftNode);
			}

			if (rightNode != '.') {
				root.right = new Node(rightNode);
			}
		} else { //그 다음 부터
			searchNode(root, data, leftNode, rightNode);
		}
	}

	public void searchNode(Node node, char data, char leftNode, char rightNode) {
		if (node == null) // base condition 
			return;

		if (node.data == data) { //탐색 완료했다면 자식노드 생성
			if (leftNode != '.') {
				node.left = new Node(leftNode);
			}

			if (rightNode != '.') {
				node.right = new Node(rightNode);
			}

		} else {// 탐색 못했으면 다시 자식 노드 탐색
			searchNode(node.left, data, leftNode, rightNode);
			searchNode(node.right, data, leftNode, rightNode);
		}
	}

	public void preorder(Node node) { // 전위 순회
		System.out.print(node.data); //루트
		if (node.left != null)
			preorder(node.left); //좌
		if (node.right != null)
			preorder(node.right);//우
	}

	public void inorder(Node node) { // 중위 순회
		if (node.left != null)
			inorder(node.left);//좌
		System.out.print(node.data);//루트
		if (node.right != null)
			inorder(node.right);//우
	}

	public void postorder(Node node) { // 후위 순회
		if (node.left != null)
			postorder(node.left);//좌
		if (node.right != null)
			postorder(node.right);//우
		System.out.print(node.data);//루트
	}

}

public class BOJ_1991_S1_트리순회 { //Main부분
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			tree.createNode(temp[0], temp[2], temp[4]);

		} // end of reading

		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);

	}

}
