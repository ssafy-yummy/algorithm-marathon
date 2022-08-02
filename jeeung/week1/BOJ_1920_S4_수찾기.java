import java.util.*;
import java.io.File;

public class BOJ_1920_S4_수찾기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input_1e5.txt"));
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // a - b하면 에러. compareTo로 반환해야됨
        Arrays.sort(arr, (a, b) -> {
            return a.compareTo(b);
        });

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();
            int s = 0, e = n - 1;
            int mid = 0;

            // m <= 100,000, arr <= 100,000
            // 이분 탐색으로 arr 탐색을 O(log N)으로 만듦
            while (s <= e) {
                mid = (s + e) / 2;
                if (arr[mid] == target) {
                    break;
                }

                else if (arr[mid] < target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            // 값을 찾았으면 mid 인덱스가 target을 가리킴
            System.out.println(arr[mid] == target ? 1 : 0);

        }
    }
}