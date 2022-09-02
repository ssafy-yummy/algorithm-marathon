import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_G5_로봇청소기 {

    static class Robot {
        int x, y, d, count;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public void clean() {
            if (board[this.x][this.y] == 0) {
                board[this.x][this.y] = 2;
                this.count++;
            }
        }

        public boolean findLeft() {
            int nx = this.x + dx[(this.d - 1 + 4) % 4];
            int ny = this.y + dy[(this.d - 1 + 4) % 4];
            return board[nx][ny] == 0 ? true : false;
        }

        public boolean search() {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int nx = this.x + dx[i];
                int ny = this.y + dy[i];
                if (board[nx][ny] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int nx = this.x + dx[(this.d - 2 + 4) % 4];
                int ny = this.y + dy[(this.d - 2 + 4) % 4];
                if (board[nx][ny] == 1)
                    return false;
                else {
                    this.x = nx;
                    this.y = ny;
                }
            } else {
                if (this.findLeft()) {
                    this.d = (this.d - 1 + 4) % 4;
                    this.x += dx[this.d];
                    this.y += dy[this.d];
                } else {
                    this.d = (this.d - 1 + 4) % 4;
                }
            }
            return true;
        }
    }

    static int n, m, r, c, d;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[m][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        Robot robot = new Robot(c, r, d);

        while (true) {
            robot.clean();
            if (!robot.search())
                break;
        }
        sb.append(robot.count);

        System.out.println(sb.toString());
    }
}