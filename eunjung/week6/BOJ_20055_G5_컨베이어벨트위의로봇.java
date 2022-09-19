package week6;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {
    static int N,K;
    static int[] A;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2*N]; // 벨트
        robot = new boolean[N]; // 로봇

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 회전함수 호출
        System.out.println(rotate(0));
    }

    public static int rotate(int cnt) {
    	// 내구도가 0인 칸의 개수가 K개 이상인지 확인
        while (check()) {
        	
        	// 벨트 회전
        	int tmp = A[2*N-1];
        	for (int i = 2*N-1; i > 0; i--) {
        		A[i] = A[i-1];
			}
            A[0] = tmp;
            
            // 로봇 회전
            for (int i = N-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
            robot[0] = false; // 올리는 위치 초기화
            robot[N-1] = false; // 내리는 위치 초기화
            
            // 로봇 이동
            for (int i = N-1; i > 0; i--) {
                if (robot[i-1] && !robot[i] && A[i] >= 1) {
                    robot[i] = true;
                    robot[i-1] = false;
                    A[i]--; // 내구도 감소
                }
            }
            
            // 로봇 새로 올리기
            if (A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }
            cnt++; // 단계 증가
        }
        
        return cnt;
    }


	private static boolean check() {
        int cnt = 0;

        for (int i = 0; i < 2*N; i++) {
            if (A[i] == 0) cnt++;
            if (cnt >= K) return false;
        }
        return true;
    }
}