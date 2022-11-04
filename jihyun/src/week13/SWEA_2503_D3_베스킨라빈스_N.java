package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SWEA_2503_D3_베스킨라빈스_N {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1;tc<=T;tc++) {
             
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
             
            if(n%4==1)
                answer=1;
         
                     
            System.out.printf("#%d %d\n",tc, answer);
        }
         
    }
}