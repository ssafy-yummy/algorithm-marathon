import java.io.*;
import java.util.*;

public class BOJ_13305_S4_주유소 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] dists = new long[n - 1];
        long[] prices = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dists[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long minVal = Integer.MAX_VALUE;

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < minVal)
                minVal = prices[i];
            ans += minVal * dists[i];
        }

        sb.append(ans);

        System.out.println(sb.toString());

    }
}
