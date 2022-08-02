import java.util.*;

public class BOJ_2667_S1_단지번호붙이기 {
    static int n;
    static int[][] board;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    // 4방향으로 위치를 넘기면서 범위를 넘어가거나 방문했던 곳이면 0 리턴
    // 방문하면서 cnt를 1 증가시켜줌
    // 이전에 dfs를 돌면서 방문처리하며 얻은 cnt값을 누적시켜주며 반환
    public static int dfs(int x, int y) {
        if (!(0 <= x && x < n && 0 <= y && y < n))
            return 0;

        if (board[x][y] == 0)
            return 0;

        // 방문 처리
        board[x][y] = 0;

        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            cnt += dfs(nx, ny);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            // String으로 입력을 받아 char[]로 변환하여 board에 입력
            char[] temp = sc.next().toCharArray();

            for (int j = 0; j < n; j++) {
                board[i][j] = temp[j] - '0';
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문했으면 넘기기
                if (board[i][j] == 0)
                    continue;

                ans.add(dfs(i, j));
            }
        }

        ans.sort((a, b) -> a - b);

        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }
}