package week2.BOJ_1991_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	public void createNode(char data, char leftNode, char rightNode) {
		if (root == null) {
			root = new Node(data);

			if (leftNode != '.') {
				root.left = new Node(leftNode);
			}

			if (rightNode != '.') {
				root.right = new Node(rightNode);
			}
		} else {
			searchNode(root, data, leftNode, rightNode);
		}
	}

	public void searchNode(Node node, char data, char leftNode, char rightNode) {
		if (node == null)
			return;

		if (node.data == data) {
			if (leftNode != '.') {
				node.left = new Node(leftNode);
			}

			if (rightNode != '.') {
				node.right = new Node(rightNode);
			}

		} else {
			searchNode(node.left, data, leftNode, rightNode);
			searchNode(node.right, data, leftNode, rightNode);
		}
	}

	public void preorder(Node node) {
		System.out.print(node.data);
		if (node.left != null)
			preorder(node.left);
		if (node.right != null)
			preorder(node.right);
	}

	public void inorder(Node node) {
		if (node.left != null)
			inorder(node.left);
		System.out.print(node.data);
		if (node.right != null)
			inorder(node.right);
	}

	public void postorder(Node node) {
		if (node.left != null)
			postorder(node.left);
		if (node.right != null)
			postorder(node.right);
		System.out.print(node.data);
	}

}

public class BOJ_1991_S1_트리순회 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
//			char[] temp = br.readLine().toCharArray();
//			tree.createNode(temp[0], temp[2], temp[4]);
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		} // end of reading

		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);

	}

}
