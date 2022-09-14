package com.boj.boj5567;

import java.util.*;

public class Main {

    // 입력을 받기 위한 n,m 변수 선언
    static int n, m;
    // 결과 반환을 위한 변수 선언
    static int result;

    // 연관관계를 나타내기 위한 arr변수 선언
    static ArrayList<Integer>[] arr;

    // 방문 여부를 탐색하기 위한 visited 변수 선언
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt()-1;
            int to = sc.nextInt()-1;

            arr[from].add(to);
            arr[to].add(from);
        }

        visited[0] = true;
        bfs();
        System.out.println(result);
    }

    //bfs 함수 선언,
    private static void bfs(){
        // 정수를 받기 위한 queue선언
        Queue<Integer> queue = new LinkedList<>();
        // queued에 시작값인 1-1 = 0 값 삽입
        queue.offer(0);

        // 깊이를 탐색하기 위한 depth변수를 0으로 초기화
        int depth = 0;

        // queue가 빌때까지 반복수행
        while (!queue.isEmpty()){
            // 친구의 친구까지인 depth = 2일때 반복 종료
            if(depth == 2) break;
            int size = queue.size();
            // 현재 깊이의 모든 친구들을 탐색
            for (int i = 0; i < size; i++) {
                // 현재깊이의 친구가 갖고 있는 모든 친구들의 정보가 담긴 ArrayList를 가져와
                // 향상된 for문을 통해 검사 수행
                int tmp = queue.poll();
                for (int guest : arr[tmp]) {
                    // 이미 한번 방문한 친구일 경우 continue
                    if (visited[guest]) continue;
                    // 친구에 대해 visited = true
                    visited[guest] = true;
                    //결과 카운트에 대해 1증가
                    result++;
                    // queue에 해당 친구를 추가한다.
                    queue.offer(guest);
                }
            }
            // 깊이를 1증가시킨다
            depth ++;
        }
    }
}