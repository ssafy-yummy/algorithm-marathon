package com.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_86971_전력망을둘로나누기 {
    static boolean visited[];
    static List<Integer>[] tree;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        visited = new boolean[n];
        tree = new List[n];
        // 배열 초기화
        for(int i = 0; i< n; i++) tree[i] = new ArrayList<Integer>();

        // 트리 생성
        for(int i = 0; i < wires.length; i++){
            tree[wires[i][0]-1].add(wires[i][1]-1);
            tree[wires[i][1]-1].add(wires[i][0]-1);
        }

        //하나씩 제거해보는 작업
        for(int i = 0; i< n; i++){
            for(int j = 0; j < tree[i].size(); j++){
                // visited[tree[i].get(j)] = true;
                int tmp = tree[i].get(j);
                int idx = tree[tmp].indexOf(i);
                tree[i].remove(j);
                tree[tmp].remove(idx);

                checkVal(0, n);

                tree[i].add(tmp);
                tree[tmp].add(i);
                Collections.sort(tree[i]);
                Collections.sort(tree[tmp]);

                int cnt = 0;
                for(int k = 0; k< visited.length; k++) if(visited[k]) cnt++;
                answer = Math.min(answer, Math.abs((n-cnt) - cnt));

                visited = new boolean[n];
            }
        }

        return answer;
    }

    public static void checkVal(int x, int n){
        visited[x] = true; // 방문처리
        for(int i = 0; i<tree[x].size(); i++){
            int tmp =tree[x].get(i);
            if(visited[tmp]) continue; // 이미 방문했다면 패스하자
            checkVal(tmp, n);
        }
    }
}
