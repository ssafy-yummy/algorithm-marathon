package week20;

import java.util.*;

public class PG_LV2_행렬테두리회전하기 {

    static Queue<Integer> que1, que2;
    
	public static void main(String[] args) {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5 ,1};
		System.out.println(solution(queue1,queue2));
	}

    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = sum(queue1);
        long sum2 = sum(queue2);
        if(!makeQue(queue1, queue2, sum1+sum2)) return -1;
        int answer = 0;
        while(sum1 != sum2) {
            answer++;
            if(answer > que1.size()*2+que2.size()*2) return -1;
            if(que1.size()==0 || que2.size()==0) return -1;
            if(sum1 > sum2) {
                int temp = que1.poll();
                que2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
            } else {
                int temp = que2.poll();
                que1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
            }
        }
        return answer;
    }
    static long sum(int[] que) {
        long s = 0;
        for(int q: que) {
            s += q;
        }
        return s;
    }
    static boolean makeQue(int[] queue1, int[] queue2, long sum) {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
        for(int q: queue1) {
            if(q > sum/2) return false;
            que1.offer(q);
        }
        for(int q: queue2) {
            if(q > sum/2) return false;
            que2.offer(q);
        }
        return true;
    }
    
    
}