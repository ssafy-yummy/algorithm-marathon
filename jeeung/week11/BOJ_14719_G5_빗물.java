import java.io.*;
import java.util.*;

public class BOJ_14719_G5_빗물 {
    static int h, w, tc;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < h; i++) {
            boolean flag = false;
            int count = 0;
            for (int j = 0; j < w; j++) {
                if (flag && arr[j] > i) {
                    tc += count;
                    count = 0;
                    flag = false;
                }

                if (flag)
                    count++;

                if (arr[j] > i)
                    flag = true;
            }
        }

        sb.append(tc);

        System.out.println(sb.toString());

    }
}