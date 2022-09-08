import java.io.*;
import java.util.*;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {
    static int n, k;
    static int[] arr;

    static boolean[] robots;

    static void move() {
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] > 0 && robots[i] && !robots[i + 1]) {
                arr[i + 1]--;
                robots[i + 1] = true;
                robots[i] = false;
            }
        }
        robots[n - 1] = false;
    }

    static void rotate() {
        int temp = arr[2 * n - 1];
        for (int i = 2 * n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
            if (i < n - 1 && robots[i]) {
                robots[i + 1] = true;
                robots[i] = false;
            }
        }
        arr[0] = temp;
        robots[n - 1] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n * 2];
        robots = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int level = 1;
        while (true) {
            rotate();
            move();
            if (arr[0] > 0) {
                arr[0]--;
                robots[0] = true;
            }
            int count = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (arr[i] == 0)
                    count++;
            }
            if (count >= k)
                break;
            level++;
        }
        sb.append(level);
        System.out.println(sb.toString());
    }
}