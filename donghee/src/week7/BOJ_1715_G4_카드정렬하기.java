package week7;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715_G4_카드정렬하기 {
	
	static int N;
	static PriorityQueue<Integer> cards;
	static int result,saved;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc= new Scanner(System.in) ;
		N= sc.nextInt();
		
		cards = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			cards.add(sc.nextInt());
		}
		
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		}
		
		while(!cards.isEmpty()) {
			int temp =cards.poll() + cards.poll();
			result +=temp;
			if(cards.isEmpty()) {
				break;
			}
			cards.add(temp);
		}
		System.out.println(result);
	}

}
