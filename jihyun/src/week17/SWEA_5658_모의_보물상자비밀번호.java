package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_5658_모의_보물상자비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); //숫자 개수
			int m = Integer.parseInt(st.nextToken())-1; //몇번째로 큰숫자
			String str = br.readLine(); //n개의 숫자들
			Set<String> set = new HashSet<>();
			List<String> list = new ArrayList<>();
			
			for(int c=0;c<n/4;c++) { //c회전
				int index=0;
				for(int i=0;i<4;i++) {
					String temp = "";
					for(int j=0;j<n/4;j++) {
						temp+=str.charAt(((index++)+c)%n);
					}
					if(!set.contains(temp)) {
						set.add(temp);
						list.add(temp);
					}
				}
			}
			list.sort(Comparator.reverseOrder());
			
			String mth = list.get(m);
			
			answer = Integer.parseInt(mth,16);
			
			System.out.printf("#%d %d\n",tc,answer);
		}
	}

}
