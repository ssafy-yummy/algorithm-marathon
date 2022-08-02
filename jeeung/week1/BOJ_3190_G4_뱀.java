import java.util.*;

public class BOJ_3190_G4_뱀 {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int d = 0; // 방향

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Deque<Integer[]> snake = new LinkedList<>();
        HashMap<Integer, String> coms = new HashMap<>();
        int n = sc.nextInt();
        int[][] board = new int[n][n]; // 0 빈 공간, 1 사과, 2 뱀
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[b - 1][a - 1] = 1; // 문제에서 인덱스 하나씩 줄어들어있음
        }

        int l = sc.nextInt();

        for (int i = 0; i < l; i++) {
            int a = sc.nextInt();
            String b = sc.next();
            coms.put(a, b);
        }

        Integer[] temp = new Integer[] { 0, 0 };
        snake.add(temp);
        board[0][0] = 2;

        // 마지막으로 컨트롤 하는 시간은 1만초, 이 후 최대 보드크기인 100만큼 더 갈 수 있음
        for (Integer t = 1; t < 10100; t++) {
            Integer[] xy = snake.getLast(); // 뒤 쪽이 머리, 앞 쪽이 꼬리
            int x = xy[0], y = xy[1];

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 나갈 때
            if (!((0 <= nx && nx < n) && (0 <= ny && ny < n))) {
                System.out.println(t);
                System.exit(0);
            }

            // 부딪힐 때
            if (board[nx][ny] == 2) {
                System.out.println(t);
                System.exit(0);
            }

            // 진행 방향에 사과가 없으면 꼬리를 줄임
            if (board[nx][ny] == 0) {
                Integer[] _xy = snake.removeFirst();
                int _x = _xy[0], _y = _xy[1];
                board[_x][_y] = 0;
            }

            board[nx][ny] = 2;

            // 진행 방향으로 머리를 늘림
            temp = new Integer[] { nx, ny };
            snake.add(temp);

            // hashmap의 키-값을 시간-커맨드로 받아서 해당 시간에 도달하면 커맨드 반환
            if (coms.get(t) != null) {
                if (coms.get(t).equals("D"))
                    d = (d + 1) % 4;
                else if (coms.get(t).equals("L"))
                    d = (d + 4 - 1) % 4;
            }
        }
    }
}