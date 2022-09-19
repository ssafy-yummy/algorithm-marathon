package week7;

import java.io.*;
import java.util.*;

public class BOJ_12100_G2_2048 {
   static int N;
   static int result;
   static int[][] map;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];
      
      for (int i=0; i< N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j=0; j< N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      dfs(0);
      System.out.println(result);
   }
   
   
   private static void dfs(int count) {
      if (count == 5) {
         for (int i=0; i< N; i++) {
            for (int j=0; j< N; j++) {
               result = Math.max(result, map[i][j]);
            }
         }
         return;
      }
      else {
         int[][] tmp = new int[N][N];
         for (int i=0; i<N; i++) {
            tmp[i] = map[i].clone();
         }
         
         for (int i=0; i<4; i++) {
            move(i);
            dfs(count + 1);
            for (int j=0; j<N; j++) {
               map[j] = tmp[j].clone();
            }      
         }
      }
   }

   // 상하좌우로 이동 후 점수합치기
   private static void move(int k) {
       switch(k) {
           //위로 몰기
         case 0:
             for(int i = 0; i < N; i++) {
                 int index = 0;
                 int block = 0;
                 for(int j = 0; j < N; j++) {
                     if(map[j][i] != 0) {
                         if(block == map[j][i]) {
                             map[index - 1][i] = block * 2;
                             block = 0;
                             map[j][i] = 0;
                         }
                         else {
                             block = map[j][i];
                             map[j][i] = 0;
                             map[index][i] = block;
                             index++;
                         }
                     }
                 }
             }
             break;
         //왼쪽으로 몰기
         case 1:
             for(int i = 0; i < N; i++) {
                 int index = N - 1;
                 int block = 0;
                 for(int j = N - 1; j >= 0; j--) {
                     if(map[j][i] != 0) {
                         if(block == map[j][i]) {
                             map[index + 1][i] = block * 2;
                             block = 0;
                             map[j][i] = 0;
                         }
                         else {
                             block = map[j][i];
                             map[j][i] = 0;
                             map[index][i] = block;
                             index--;
                         }
                     }
                 }
             }
             break;
         //왼쪽으로 몰기
         case 2:
             for(int i = 0; i < N; i++) {
                 int index = 0;
                 int block = 0;
                 for(int j = 0; j < N; j++) {
                     if(map[i][j] != 0) {
                         if(block == map[i][j]) {
                             map[i][index - 1] = block * 2;
                             block = 0;
                             map[i][j] = 0;
                         }
                         else {
                             block = map[i][j];
                             map[i][j] = 0;
                             map[i][index] = block;
                             index++;
                         }
                     }
                 }
             }
             break;
         //오른쪽으로 몰기
          case 3:
              for(int i = 0; i < N; i++) {
                  int index = N - 1;
                  int block = 0;
                  for(int j = N - 1; j >= 0; j--) {
                      if(map[i][j] != 0) {
                          if(block == map[i][j]) {
                              map[i][index + 1] = block * 2;
                              block = 0;
                              map[i][j] = 0;
                          }
                          else {
                              block = map[i][j];
                              map[i][j] = 0;
                              map[i][index] = block;
                              index--;
                          }
                      }
                  }
              }
              break;
       }
   }

}