import java.util.*;
import java.io.File;

class Node {
    int data;
    Node l, r;

    public Node(int data) {
        this.data = data;
        this.l = null;
        this.r = null;
    }
}

class Tree {
    static void preorder(Node now) {
        if (now == null)
            return;

        System.out.print((char) (now.data + 'A'));
        preorder(now.l);
        preorder(now.r);
    }

    static void inorder(Node now) {
        if (now == null)
            return;

        inorder(now.l);
        System.out.print((char) (now.data + 'A'));
        inorder(now.r);
    }

    static void postorder(Node now) {
        if (now == null)
            return;

        postorder(now.l);
        postorder(now.r);
        System.out.print((char) (now.data + 'A'));
    }
}

public class BOJ_1991_S1_트리순회 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Node[] nodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            String s_abc = sc.nextLine();
            int a = s_abc.charAt(0) - 'A';
            int b = s_abc.charAt(2) - 'A';
            int c = s_abc.charAt(4) - 'A';

            if (b != '.' - 'A')
                nodes[a].l = nodes[b];

            if (c != '.' - 'A')
                nodes[a].r = nodes[c];
        }

        Tree.preorder(nodes[0]);
        System.out.println();
        Tree.inorder(nodes[0]);
        System.out.println();
        Tree.postorder(nodes[0]);
    }
}