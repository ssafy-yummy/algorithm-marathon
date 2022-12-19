package week20;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2110_G4_공유기설치 {

	static int[] houses;
	static int n;
	static int c;
	static int answer;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		c = sc.nextInt();
		houses = new int[n];
		answer = 0;
		int maxs = 0;
		for (int i = 0; i < n; i++) {
			
			int a = sc.nextInt();
			houses[i] = a;
			maxs = Math.max(maxs, houses[i]);
		}
		
		Arrays.sort(houses);
		binarySearch(1,maxs);
		System.out.println(answer);
		
		
		
	}

	private static void binarySearch(int left, int right) {

		int mid = (left+right)/2;
		if(mid==left) {
			check(right);
			check(left);
			return;
		}
		
		if(check(mid)) {
			binarySearch(mid, right);
		}
		else {
			binarySearch(left, mid);
		}
		
	}

	private static boolean check(int mid) {
		
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			
			if(k==c)
				break;
			
			if(stack.isEmpty()) {
				stack.push(houses[i]);
				k++;
				continue;
			}
			
			if(houses[i] - stack.peek() < mid) {
				cnt++;
				if(cnt>n-c)
					return false;
			}
			else {
				stack.push(houses[i]);
				k++;
			}
		}
		
		answer = mid;
		return true;
		
	}

}
