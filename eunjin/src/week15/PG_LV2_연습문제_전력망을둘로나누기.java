package week15;

import java.util.Arrays;

public class PG_LV2_연습문제_전력망을둘로나누기 {

	static int n, wires[][], ROOT[], root[], ans;
	
	public static void main(String[] args) {
		int a = 9;
		int b[][] = new int[][] {{1,3},{4,7},{7,8},{7,9},{2,3},{3,4},{4,5},{4,6}};

		System.out.println(Solution(a, b));
		return;
	}

	private static int Solution(int n2, int[][] wires2) {
		n = n2;
		wires = wires2;
		
		ans = Integer.MAX_VALUE;
		make();
		root = new int[n+1];
		for (int i = 0; i < n-1; i++) {
			// 1. 전선 하나를 제거한 후 root(조상노드)를 검색해보기
			root = Arrays.copyOf(ROOT, n+1);
			for (int j = 0; j < n-1; j++) {
				if(i==j) continue;	// 전선 하나를 제거한 경우 (완전탐색)
				union(wires[j]);
			}
			
			// 2. root 마지막으로 정리하기
			for (int j = 1; j < n+1; j++) {
				find(j);
			}
			
			// 3. 두 가지 갈래로 나눈 트리의 노드 개수 비교하기
			int k = root[1];
			int cnt1 = 0;
			int cnt2 = 0;
			for (int j = 1; j < n+1; j++) {
				if(root[j] == k) cnt1++;
				else cnt2++;
			}
			
			ans = Math.min(ans, Math.abs(cnt1-cnt2));
		}
		return ans;
	}

	private static void union(int[] arr) {
		int a = find(arr[0]);
		int b = find(arr[1]);
		
		if(a==b) return;
		
		if(a<b) {
			root[b] = a;
		} else {
			root[a] = b;
		}
	}

	private static int find(int a) {
		if(root[a]==a) return a;
		return root[a] = find(root[a]);
	}

	private static void make() {
		ROOT = new int [n+1];
		for (int i = 1; i < n+1; i++) {
			ROOT[i] = i;
		}
	}

}
