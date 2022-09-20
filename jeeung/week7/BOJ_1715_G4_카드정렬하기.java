import java.io.*;
import java.util.*;

public class BOJ_1715_G4_카드정렬하기 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < n - 1; i++) {
            int a = pq.poll();
            int b = pq.poll();

            int temp = a + b;
            ans += temp;

            pq.add(temp);
        }

        sb.append(ans);

        System.out.println(sb.toString());

    }
}