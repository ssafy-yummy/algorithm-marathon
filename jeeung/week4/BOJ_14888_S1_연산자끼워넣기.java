import java.io.*;
import java.util.*;

public class BOJ_14888_S1_연산자끼워넣기 {

    static int n;
    static int[] operands;
    static int[] operators = new int[4];

    static int minVal = Integer.MAX_VALUE;
    static int maxVal = Integer.MIN_VALUE;

    static void backtrack(int idx, int val) {
        if (idx == n) {
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0)
                continue;
            operators[i]--;
            if (i == 0)
                backtrack(idx + 1, val + operands[idx]);
            else if (i == 1)
                backtrack(idx + 1, val - operands[idx]);
            else if (i == 2)
                backtrack(idx + 1, val * operands[idx]);
            else if (i == 3) {
                if (val >= 0)
                    backtrack(idx + 1, val / operands[idx]);
                else
                    backtrack(idx + 1, -(-val / operands[idx]));
            }
            operators[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        operands = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, operands[0]);
        sb.append(maxVal).append("\n").append(minVal);

        System.out.println(sb.toString());

    }
}