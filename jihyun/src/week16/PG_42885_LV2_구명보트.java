package week16;

import java.util.Arrays;

public class PG_42885_LV2_구명보트 {
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		Solution s = new Solution();
		int result = s.solution(people, limit);
		System.out.println(result);
	}
}

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int start = 0; // 가장 가벼운 사람 인덱스
		int end = people.length - 1; // 가장 무거운 사람 인덱스
		while (start<end) {
			if (people[start] + people[end] <= limit) {
				answer++;
				start++;
				end--;
			}
			else {
				answer++;
				end--;
			}
		}
		if(start==end)
			answer++;
		return answer;
	}
}