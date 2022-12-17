package week15;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] map;
    static boolean[][] visited,visited2;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int[] w : wires){
            int a = w[0]-1;
            int b = w[1]-1;
            map[a][b]=1;
            map[b][a]=1;
        }
        
        for(int [] m:map){
            System.out.println(Arrays.toString(m));
        }
        
        
        for(int i =0 ; i < n ; i++){
            for(int j =0 ; j< n; j++){
                if(map[i][j]==1 && !visited[i][j] ){
                    map[i][j]=2;
                    map[j][i]=2;
                    visited[i][j]=true;
                    visited[j][i]=true;
                    int sum = start(n,wires);
                    map[i][j]=1;
                    map[j][i]=1;
                    
                    answer = Math.min(answer,Math.abs(sum - (n-sum)));
                }
            }
        }
        
        
        return answer;
    }
    
    public static int start(int n , int[][] wires){
        Queue<Integer> que = new LinkedList<>();
        visited2= new boolean[n][n];
        int sum =-1;
        for(int[] w : wires){
            int a=  w[0]-1;
            int b = w[1]-1;
            if(map[a][b]==1){
                que.offer(a);
                que.offer(b);
                visited2[a][b]=true;
                visited2[b][a]=true;
                sum =2;
                System.out.println("a = " +a);
                System.out.println("b = " +b);
                break;
            }
        }
        
        while(!que.isEmpty()){
            int cur = que.poll();
            System.out.println("cur = " +cur);
            for(int i =0; i <n; i++){
                if(!visited2[cur][i] && map[cur][i]==1){
                    visited2[cur][i]=true;
                    visited2[i][cur]=true;
                    sum++;
                    System.out.println("sum = " + sum);
                    que.offer(i);
                }
            }
        }
        
        return sum;
    }
}
