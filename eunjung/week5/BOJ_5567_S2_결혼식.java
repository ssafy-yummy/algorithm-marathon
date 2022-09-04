package boj;
import java.util.*;
import java.io.*;
 
public class BOJ_5567_S2_결혼식 { 
    static int N,M,cnt;        
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
 
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
 
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            arr[a].add(b);
            arr[b].add(a); // 친구관계를 리스트에 저장
        }
                
        ArrayList<Integer> list = new ArrayList<>();
 
        for(int fr : arr[1]){
            list.add(fr);
            visited[fr] = true; // 상근이의 친구관계
        }
 
        for(int i=0; i<list.size(); i++){
            for(int frfr : arr[list.get(i)]){
                visited[frfr] = true; // 상근이 친구의 친구
            }
        }
 
        for(int i=2; i<=N; i++){
            if(visited[i]) cnt++; // 결혼식 가는 사람들 조사
        }
        
        System.out.println(cnt); // 출력
    }
}