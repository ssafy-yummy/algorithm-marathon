import java.io.*;
import java.util.*;

public class BOJ_23843_G5_콘센트 {
    static int n, m;
    static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> b - a);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.add(0);
        }

        for (int i = 0; i < n; i++) {
            int temp = pq.poll();
            temp += arr[i];
            pq.add(temp);
        }

        int maxVal = 0;
        for (int i = 0; i < m; i++) {
            maxVal = Math.max(maxVal, pq.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal);

        System.out.println(sb.toString());

    }
}