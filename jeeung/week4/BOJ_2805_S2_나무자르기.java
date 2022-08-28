import java.io.*;
import java.util.*;

// 높이의 최대값
// 값이 나눠떨어지지 않는 경우 더 잘라야 정답

public class BOJ_2805_S2_나무자르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int s = 0, e = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e, arr[i]);
        }

        while (s <= e) {
            int m = (s + e) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (m <= arr[i])
                    sum += arr[i] - m;
            }

            if (sum >= target)
                s = m + 1;
            else
                e = m - 1;

        }
        sb.append(e);

        System.out.println(sb.toString());

    }
}