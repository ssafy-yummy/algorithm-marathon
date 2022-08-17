package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3190_G4_뱀 {
	static int N;
	static int idx;
	static int[][] map;
	static String dr;
	static int[] time;
	static String[] direction;
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        
        N = Integer.parseInt(scann.nextLine()); 
        map = new int[N][N];
        
        int appleNum = Integer.parseInt(scann.nextLine()); // 사과의 개수
        
        for(int i=0; i < appleNum; i++) {
            int r = Integer.parseInt(scann.next());
            int c = Integer.parseInt(scann.next());
            map[r-1][c-1] = 1; // 사과의 위치
        }
        
        int conv = Integer.parseInt(scann.next()); // 변환 횟수
        
        time = new int[conv]; // 시간 초
        direction = new String[conv]; // 방향
        
        for (int i=0; i<conv; i++) {
            time[i] = Integer.parseInt(scann.next());
            direction[i] = scann.next();
        }
        
        // 몸통이 있는 보드칸은 -1값으로 인식
        int result = 0;
        int r=0, y=0;
        
        Queue<Integer> tailR = new LinkedList<>();
        Queue<Integer> tailC = new LinkedList<>();
        
        if(map[r][++y] == 1) {
            // 뱀의 꼬리를 표시하고 저장
            map[r][y-1] = -1;
            tailR.add(r);
            tailC.add(y-1);
        }
        
        // 머리가 있는 부분도 뱀의 영역으로 취급
        map[r][y] = -1;
        tailR.add(r);
        tailC.add(y);
        result++;

        dr = "E"; // 오른쪽 방향으로 시작
        idx = 0;
        
        while(idx < conv) {
            if(time[idx] == result) { 
                checkDriection(); // 방향전환 지시사항이 있다면
                idx++;
            }
            // 방향 확인 후 다음 인덱스 값 구함
            if (dr.equals("E")) y++;
            if (dr.equals("W")) y--;
            if (dr.equals("S")) r++;
            if (dr.equals("N")) r--;
            
            // 다음 진행방향이 벽이나 뱀의 몸통(꼬리)부분인지 확인
            if( r < 0 || r >= N || y < 0 || y >=N || map[r][y] == -1) {
                result++;
                break;
            }
            
            // 사과가 있는 칸인지 아닌지를 판단
            if(map[r][y] == 0) { // 사과가 없다면
                map[tailR.poll()][tailC.poll()] = 0; // 꼬리칸을 줄임
            }

            map[r][y] = -1; // 현재 이동한 위치 영역 표시
            tailR.add(r);
            tailC.add(y);
            result++;
        }
        System.out.println(result); // 걸린 시간 출력
    }

    private static void checkDriection() {
        if(dr.equals("E")) {
            if(direction[idx].equals("L")) {
                dr = "N";
            }else {
                dr = "S";
            } 
        }
        else if(dr.equals("W")) {
            if(direction[idx].equals("L")) {
                dr = "S";
            }else {
                dr = "N";
            }
        }
        else if(dr.equals("S")) {
            if(direction[idx].equals("L")) {
                dr = "E";
            }else {
                dr = "W";
            }
        }
        else if(dr.equals("N")) {
            if(direction[idx].equals("L")) {
                dr = "W";
            }else {
                dr = "E";
            }
        }
    }
}