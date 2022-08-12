
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Node{
        char left;
        char right;

        public Node(char left, char right){
            this.left = left;
            this.right = right;
        }
    }

    static int n;
    static int SIZE = 3;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new Node[n+1];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int idx = tmp[0].charAt(0) - 'A';
            char left = tmp[1].charAt(0);
            char right = tmp[2].charAt(0);
            nodes[idx] = new Node(left, right);
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    static void preOrder(int current){
        char l = nodes[current].left;
        char r = nodes[current].right;

        System.out.print((char)(current + 'A'));


        if (l != '.') preOrder(l - 'A');
        if (r != '.') preOrder(r - 'A');
    }
    static void inOrder(int current){
        char l = nodes[current].left;
        char r = nodes[current].right;


        if (l != '.') inOrder(l - 'A');
        System.out.print((char)(current + 'A'));
        if (r != '.') inOrder(r - 'A');

    }
    static void postOrder(int current){
        char l = nodes[current].left;
        char r = nodes[current].right;

        if (l != '.') postOrder(l - 'A');
        if (r != '.') postOrder(r - 'A');
        System.out.print((char)(current + 'A'));
    }
}
