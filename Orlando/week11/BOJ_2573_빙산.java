

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
    static int r, c;
    static int[][] board;
    static boolean[][] visited;

    static StringTokenizer st;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static int cnt;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;
        while(cnt == 1){
            visited = new boolean[r][c];
            nextBoard();
            cnt = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(visited[i][j] || board[i][j] == 0) continue;
                    bfs(i, j);
                    cnt++;
                }
            }
            result++;
            if(cnt ==0 ){
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

    private static void bfs(int pr, int pc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {pr, pc});
        visited[pr][pc] = true;
        while (!queue.isEmpty()){
            int[] tmpArr = queue.poll();
            int tr = tmpArr[0];
            int tc = tmpArr[1];
            for (int i = 0; i < 4; i++) {
                int nr = tr + dr[i];
                int nc=  tc + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || board[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    private static void nextBoard() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cnt = 0;
                if(board[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(!isCheck(nr, nc)) continue;
                    if(board[nr][nc] == 0) cnt++;
                }

                board[i][j] = board[i][j]-cnt > 0 ? board[i][j]-cnt : 11;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] == 11) board[i][j] = 0;
            }
        }
    }

    static boolean isCheck(int nr, int nc){
        return 0<= nr && nr < r && 0 <= nc && nc < c;
    }
}
