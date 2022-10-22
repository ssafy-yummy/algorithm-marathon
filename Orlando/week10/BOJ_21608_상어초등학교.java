package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {
    static int n, size;
    static int[][] board;
    static List<Student> list;
    static int result;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] score = {0, 1, 10, 100, 1000};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        size = n * n;
        board = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int[] tmpArray = new int[4];
            for (int j = 0; j < 4; j++) {
                tmpArray[j] = Integer.parseInt(st.nextToken());
            }
            Student student = new Student(tmp, tmpArray);
            list.add(student);
            searchLocation(student);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                getResult(i, j);
            }
        }
        System.out.println(result);
    }

    private static void getResult(int r, int c) {
        int cnt = 0;
        for (Student student : list) {
            if(student.num == board[r][c]){
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(!isCheck(nr, nc)) continue;
                    for (int tmp : student.favorite) {
                        if(tmp == board[nr][nc]) {
                            cnt++;
                            break;
                        }
                    }
                }
                break;
            }

        }
        result += score[cnt];
    }

    static void searchLocation(Student student){
        int val = 0;
        int zeroVal = 0;
        int r = n/2;
        int c = n/2;

        // 모든 위치를 순회한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0) continue; // 이미 있는 위치는 넘긴다.
                int[] tmp = checkArea(i, j, student);
                if(tmp[0] > val){
                   val = tmp[0];
                   zeroVal = tmp[1];
                   r = i;
                   c = j;
                }else if(tmp[0] == val && tmp[1] >= zeroVal){
                    val = tmp[0];
                    zeroVal = tmp[1];
                    r = i;
                    c = j;
                }
            }
        }
        board[r][c] = student.num;
    }

    private static int[] checkArea(int r, int c, Student student) {
        int cnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!isCheck(nr, nc)) continue;
            if(board[nr][nc] == 0) zeroCnt++;
            for (int favorite : student.favorite) {
                if(board[nr][nc] == favorite){
                    cnt++;
                }
            }
        }
        return new int[]{cnt, zeroCnt};
    }



    //상하좌우를 체크하기 위한 메서드
    static boolean isCheck(int r, int c){
        return 0<=r && r < n && 0<= c && c < n;
    }

    static class Student{
        int num;
        int[] favorite;
        public Student(int num, int[] favorite) {
            this.num = num;
            this.favorite = favorite;
        }
    }
}
//선호하는 학생들의 자리를 구한다.
