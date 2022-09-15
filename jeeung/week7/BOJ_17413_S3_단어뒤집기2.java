import java.io.*;
import java.util.*;

public class BOJ_17413_S3_단어뒤집기2 {

    static char[] cs;
    static boolean angled;

    static ArrayList<Character> buffer = new ArrayList<>();
    static Stack<Character> stack = new Stack<>();

    static void flush() {
        while (!stack.isEmpty())
            buffer.add(stack.pop());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        cs = br.readLine().toCharArray();

        for (char c : cs) {
            if (c == ' ') {
                flush();
                buffer.add(c);
                continue;
            }

            if (c != '<' && c != '>') {
                if (!angled)
                    stack.add(c);
                else
                    buffer.add(c);
                continue;
            }

            if (c == '<') {
                flush();
                angled = true;
            } else if (c == '>')
                angled = false;

            buffer.add(c);

        }
        flush();

        for (char c : buffer) {
            sb.append(c);
        }
        System.out.println(sb.toString());

    }
};