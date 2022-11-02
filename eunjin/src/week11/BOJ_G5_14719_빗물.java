package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_14719_빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>(H+1);
        for (int i = 0; i < H+1; i++) {
            adjlist.add(new ArrayList<>());
        }
        int hMap[] = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int a = Integer.parseInt(st.nextToken());
            adjlist.get(a).add(i);    // adjlist.get(높이).add(인덱스) : 높이별 블록의 인덱스를 저장함
            hMap[i] = a;	// 블록의 높이를 저장
        } //read
        
        int map[] = new int[W];
        Arrays.fill(map, -1);    // map[] : 빗물이 몇 칸까지 고일 것인지 저장. -1:아직검사하지않은블록
        
        int count = 0;	// W개의 블록을 다 검사하였는지 체크. map[] 배열의 값이 변할 때마다 +1
        
        // 1. 최대 높이에서부터 시작해서 0까지 낮춰가면서 빗물이 고이는 블록을 검사한다
        for (int h = H; h >= 0; h--) {
            int n = adjlist.get(h).size();
            if(n==0) continue;    // h 높이의 블록이 한 개도 없다면 pass
            
            // 2. h 높이에서의 블록 인덱스에 해당하는 map에 높이를 저장한다.
            for (int i = 0; i < n; i++) {
                int temp = adjlist.get(h).get(i);
                if(map[temp]==-1) {    // 검사하지 않은 블록인 경우
	                map[temp] = h;
	                count++;
                }
            }
            
            // 3. map에 높이를 기준으로 주변 블록의 높이를 저장해 준다.
            for (int i = 0; i < n; i++) {
            	int temp = adjlist.get(h).get(i);
            	for (int j = 1; j < temp; j++) {	// 왼쪽 부분
            		if(map[j-1]!=-1 && map[j]==-1) {
            			map[j] = h;
            			count++;
            		}
            	}
            	for (int j = W-2; j > temp; j--) {	// 오른쪽 부분
            		if(map[j+1]!=-1 && map[j]==-1) {
            			map[j] = h;
            			count++;
            		}
            	}
			}
            
            // 4. 만약 count==W라면 즉, 모든 블록은 검사하였다면 for문을 빠져나가도 된다.
            if(count==W) break;
            
        }
        
        // 5. 고인 빗물 구하기
        int ans = 0;
        for (int i = 0; i < W; i++) {
			ans += (map[i]-hMap[i]);
		}
        System.out.println(ans);
    }
}