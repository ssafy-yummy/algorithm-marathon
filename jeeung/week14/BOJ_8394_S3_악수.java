import java.io.*;
import java.util.*;

public class BOJ_8394_S3_악수 {

    static int a, b, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = b = 1;
        int temp = 0;
        for (int i = 2; i < n + 1; i++) {
            temp = b;
            b = (a + b) % 10;
            a = temp % 10;
        }

        System.out.println(b % 10);

    }
}
