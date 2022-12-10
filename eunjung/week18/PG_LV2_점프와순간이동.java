package week18;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 1) ans++; // 2로 나누어 떨어지지 않을 경우는 점프 필요 
            n /= 2;
        }
        
        return ans;
    }
}