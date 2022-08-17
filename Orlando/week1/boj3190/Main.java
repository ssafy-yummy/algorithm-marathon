package com.boj.boj3190;

import java.util.*;

public class Main {
    static int n, k, l;
    static int d = 0;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, String> snake;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        board = new int[n][n];
        snake = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int y = sc.nextInt()-1;
            int x = sc.nextInt()-1;
            board[y][x] = 1;
        }

        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            String y = sc.next();
            snake.put(x,y);
        }
        move();
    }

    private static void move() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int result = 0;

        int x = 0;
        int y = 0;

        while (true) {[]
            int nx = x + dx[d];
            int ny = y + dy[d];
            result++;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                break;
            }
            if (q.contains(ny * n + nx)) {
                break;
            }
            if (board[ny][nx] == 1) {
                board[ny][nx] = 0;
                q.add(ny * n + nx);
            } else {
                q.add(ny * n + nx);
                q.poll();
            }

            if (snake.containsKey(result)) {
                String data = snake.get(result);
                if (data.equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                } else {
                    d -= 1;
                    if (d == -1) d = 3;
                }
            }
            x = nx;
            y = ny;
        }
        System.out.println(result);
    }
}
