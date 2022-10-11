package com.boj;

import java.util.*;

public class BOJ_20207_달력 {
    static int n;
    static List<Todo> todoList;
    static int[] calender;
    static int result;
    static class Todo implements Comparable<Todo>{
        int start;
        int end;
        int height;
        public Todo(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public Todo(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
        @Override
        public int compareTo(Todo o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        todoList = new ArrayList<>();
        calender = new int[30];
        for (int i = 0; i < n; i++) todoList.add(new Todo(sc.nextInt(), sc.nextInt(), 1));
        Collections.sort(todoList);
        makeCalender();
        calcSize();

        System.out.println(result);
    }

    private static void calcSize() {
        boolean flag = false;
        int height = 0;
        int width = 0;
        for (int i = 0; i < calender.length; i++) {
            if(!flag && calender[i] != 0){
                flag = true;
                width = 1;
                height = calender[i];
            } else if(flag && calender[i] == 0){
                result += width * height;
                flag = false;
            } else if(flag && calender[i] != 0){
                if(height < calender[i]) height = calender[i];
                width ++;
            }
        }

    }

    static void makeCalender(){
        for (int t = 0; t < n; t++) {
            Todo todo = todoList.get(t);
            for (int i = todo.start; i <= todo.end; i++) {
                calender[i] += 1;
            }
        }
    }
}
