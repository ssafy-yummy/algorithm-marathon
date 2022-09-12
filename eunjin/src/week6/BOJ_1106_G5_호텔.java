package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_G5_호텔 {

    static int c, n;
    static int[] values;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        values = new int[c+101];
        Arrays.fill(values, Integer.MAX_VALUE);
        n = Integer.parseInt(st.nextToken());
        values[0] = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            for(int j=reward; j<c+101; j++){
                int prev = values[j-reward];
                if(prev!=Integer.MAX_VALUE) values[j] = Math.min(values[j], cost+prev);
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=c; i<c+101;i++){
            result = Math.min(result,values[i]);
        }
        System.out.println(result);
        br.close();
    }
}