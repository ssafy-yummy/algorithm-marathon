package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1715_G4_카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) { //오름차순 정렬 
				return a-b;
			}
		});
		for(int i=0;i<n;i++) { //모든 카드를 일단 pqueue에 넣는다.
			pqueue.offer(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while(pqueue.size()>1) { //최종적으로 한 묶음을 만드는게 묵표
			int sum = pqueue.poll()+pqueue.poll(); //가장 작은 두 값을 구해서 더한다.
			pqueue.offer(sum); //더해서 만들어진 묶음을 다시 pqueue에 넣는다.
			answer+=sum; //더해진 묶음은 합계에 더한다.
		}
		System.out.println(answer);

	}

}
