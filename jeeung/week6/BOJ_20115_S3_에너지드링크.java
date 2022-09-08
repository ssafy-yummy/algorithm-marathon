import java.io.*;
import java.util.*;

public class BOJ_20115_S3_에너지드링크 {
    static int n;
    static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> b - a);

        double temp = arr[0];

        for (int i = 1; i < n; i++) {
            temp += (double) arr[i] / 2.0;
        }

        sb.append(temp);

        System.out.println(sb.toString());

    }
}