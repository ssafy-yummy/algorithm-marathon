package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_4193_D4_수영대회결승전 {
    static int T, n, result;
    static Loc start, end;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] board;
    static boolean[][] visited;
    static List<Loc> storms;
    static Queue<Loc> queue; 

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(bf.readLine());
            result = 0;
            board = new int[n][n];
            visited = new boolean[n][n];
            storms = new ArrayList<>();

            // 배열 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    board[i][j] = tmp;
                    if (tmp == 2) {
                        storms.add(new Loc(i, j)); // 태풍 리스트에 추가
                    }
                }
            }

            // 시작 지점
            st = new StringTokenizer(bf.readLine());
            start = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 종료 지점
            st = new StringTokenizer(bf.readLine());
            end = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            //BFS 수행
            bfs();

            // 결과값이 -1일 경우 -1 그대로 출력, 아닐 경우 결과값에 -1하여 출력
            System.out.printf("#%d %d\n", t, result == -1 ? -1 : --result);
        }
    }

    static void bfs(){
        queue = new LinkedList<>();
        queue.add(start);

        visited[start.r][start.c] = true;
        result = 1;

        boolean impossibleFlag = true;
        boolean stopFlag = false;

        while (!queue.isEmpty()){
            // 2초마다 태풍이 잠잠해 지므로 3으로 나누었을 때 나머지를 통해 조건문 수행
            if(result%3==0){
                for (Loc storm : storms) {
                    board[storm.r][storm.c] = 0;
                }
            }else{
                for (Loc storm : storms) {
                    board[storm.r][storm.c] = 2;
                }
            }

            int size = queue.size();    // 현재 큐의 사이즈를 통해 얼마큼 뻗어 나갈지 지정
            for (int i = 0; i < size; i++) {    // BFS를 한번 돌릴때마다를 가정
                Loc pLoc = queue.poll();

                int pr = pLoc.r;
                int pc = pLoc.c;

                if(pr == end.r && pc == end.c) {    // 종료 될 경우
                    stopFlag = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nr = pr + dr[j];
                    int nc = pc + dc[j];
                    if(!isCheck(nr, nc) || isLand(nr, nc) || visited[nr][nc]) continue;
                    if(isStorm(nr, nc)){ // 해당 지역이 폭풍 지역일 경우
                        queue.offer(pLoc);
                    }else{
                        visited[nr][nc] = true;
                        queue.offer(new Loc(nr, nc));
                    }
                }
            }
            if(stopFlag) {  // 일치할 경우
                impossibleFlag = false;
                break;
            }
            result++;
        }
        if(impossibleFlag) result = -1; // 만약 결승지점까지 도달하지 못했을 경우
    }
    static boolean isCheck(int nr, int nc){ // 배열을 벗어나는지 체크하기 위한 메서드
        return 0<=nr&& nr< n && 0<=nc && nc<n;
    }

    static boolean isStorm(int nr, int nc){ // 폭풍우 지역인지 체크하기 위한 메서드
        return board[nr][nc] == 2;
    }

    static boolean isLand(int nr, int nc){  // 섬인지 체크하기 위한 메서드
        return board[nr][nc] == 1;
    }

    static class Loc{   // 위치 정보를 담고있는 객체를 만들기 위한 클래스
        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
