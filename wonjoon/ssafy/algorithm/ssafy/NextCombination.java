package com.ssafy.algorithm.ssafy;

// Next Combination
// nCr = nPr / (n-r)! = n!/((n-r)!*r!)
public class NextCombination {
	static int[] p = { 0, 0, 1, 1, 1 }; // >= , = 만 넣어준다.
	static int[] A = { 1, 2, 3, 4, 5 };
	static int count;
	static int N = p.length;

	public static void main(String[] args) {
		do {

			count++;
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					System.out.print(A[i] + " ");
				}
			}
			System.out.println();
		} while (nextCombi(N - 1));

		System.out.println(count);
	}

	private static boolean nextCombi(int size) {
		int i = size;
		while (i > 0 && p[i - 1] >= p[i])
			i--;

		if (i == 0)
			return false;

		int j = size;
		while (p[i - 1] >= p[j])
			j--;
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		int k = size;
		while (i < k) {
			// 스왑
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			
			
			i++;
			k--;
		}
		return true;
	}
}
