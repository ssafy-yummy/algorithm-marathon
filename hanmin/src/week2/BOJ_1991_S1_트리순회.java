package hanmin.src.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_S1_트리순회 {
	static int N;

	static class Node {
		static Node[] nodeArr = new Node[27];
		static int size = 0;
		String data;
		Node c1;
		Node c2;

		Node(String data) {
			this.data = data;
		}

		static Node findNode(String input) {
			if (input.equals("."))
				return null;
			for (int i = 0; i < size; ++i) {
				if (nodeArr[i].data.equals(input)) {
					return nodeArr[i];
				}
			}
			return nodeArr[size++] = new Node(input);
		}

		@Override
		public String toString() {
			return this.data;
		}

		static void pre(Node now) {
			System.out.print(now);
			if (now.c1 != null)
				pre(now.c1);
			if (now.c2 != null)
				pre(now.c2);
		}

		static void in(Node now) {
			if (now.c1 != null)
				in(now.c1);
			System.out.print(now);
			if (now.c2 != null)
				in(now.c2);
		}

		static void post(Node now) {
			if (now.c1 != null)
				post(now.c1);
			if (now.c2 != null)
				post(now.c2);
			System.out.print(now);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String c1 = st.nextToken();
			String c2 = st.nextToken();
			Node fst = Node.findNode(p);
			Node snd = Node.findNode(c1);
			Node trd = Node.findNode(c2);
			fst.c1 = snd;
			fst.c2 = trd;
		}
		Node root = Node.findNode("A");
		Node.pre(root);
		System.out.println();
		Node.in(root);
		System.out.println();
		Node.post(root);
		System.out.println();
	}
}
