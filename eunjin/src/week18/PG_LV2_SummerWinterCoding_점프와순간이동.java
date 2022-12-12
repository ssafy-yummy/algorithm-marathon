package week18;

public class PG_LV2_SummerWinterCoding_점프와순간이동 {

	public static void main(String[] args) {
		System.out.println(solution(5000));
	}
    public static int solution(int n) {
        int ans = 1;
        while(n!=1) {   // n이 1이 될 때까지 2를 나누는 과정을 반복한다.
            ans+=(n%2);
            n/=2;
        }
        return ans;
    }
}
