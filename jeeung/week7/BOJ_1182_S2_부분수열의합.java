import java.io.*;
import java.util.*;

public class BOJ_1182_S2_부분수열의합 {
    static int n, s;
    static int[] arr;
    static int count;

    static void subsum(int idx, int val, int picked) {

        if (idx == n) {

            if (val == s && picked > 0)
                count++;

            return;

        }

        subsum(idx + 1, val, picked);
        subsum(idx + 1, val + arr[idx], picked + 1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subsum(0, 0, 0);

        sb.append(count);

        System.out.println(sb.toString());

    }
}