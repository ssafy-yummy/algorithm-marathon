package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

    static int n, k;
    static boolean[] robot;
    static int[] container;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // 컨베이어 벨트 길이 2*N
        container = new int[2*n];
        // 로봇 위치 N
        robot = new boolean[n];

        // 배열 초기화
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < container.length; i++) {
            container[i] = Integer.parseInt(st.nextToken());
        }

        // 0의 개수가 k개가 될때까지
        while(check()) {
            rotate();
            moveRobot();
            raise();
            result++;
        }
        System.out.println(result);
    }

    // 조건 1
    private static void rotate() {
        // 컨테이너 벨트를 한칸 옮긴다.
        int tmp = container[container.length -1];
        for (int i = container.length-1; i > 0; i--) {
            container[i] = container[i-1];
        }

        container[0] = tmp;

        // 로봇도 한칸씩 옮긴다
        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        // 시작점과 끝점은 false로 초기화
        robot[0] = false;
        robot[n-1] = false;
    }

    // 조건 2
    private static void moveRobot() {
        // 두번 째 조건으로 나온 벨트위의 로봇을 하나씩 옮긴다.
        for (int i = n - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && container[i] >= 1) {
                robot[i] = true;
                robot[i - 1] = false;
                container[i]--;
            }
        }
    }

    // 조건 3
    private static void raise() {
        if(container[0] == 0) return;
        robot[0] = true;
        container[0]--;
    }

    // 반복 수행 조건 0의 개수가 k개일 때 검사
    private static boolean check(){
        int tmp = 0;

        for (int i : container) {
            if(i==0) tmp++;
            if( tmp >= k) return false;
        }
        return true;
    }
}
