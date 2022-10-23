package com.boj;

import java.util.Scanner;

public class BOJ_2564_경비원 {
    static int r, c;
    static int n;
    static Loc[] shops;
    static Loc dong;

    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        r = sc.nextInt();
        n = sc.nextInt();
        shops = new Loc[n];
        dong = new Loc();
        for (int i = 0; i < n ; i++) { // 모든 상점의 위치에 대한 초기 위치 설정
            int tmp = sc.nextInt();
            int loc = sc.nextInt();
            setLocation(tmp, loc, i);
        }
        setDong(sc.nextInt(), sc.nextInt()); // 동근이의 위치 설정

        for (Loc shop : shops) {
            if(dong.direction < 3) setNorthAndSouth(shop);
            else setWestOrEast(shop);
//            System.out.println(result);
        }
        System.out.println(result);
    }

    static void setWestOrEast(Loc shop){ // 동근이의 위치가 세로축일때
        int distance = 0;

        switch (shop.direction){
            case 1: // 상점이 북쪽
                distance += dong.r;
                if(dong.direction == 3) distance += shop.c;
                else distance += c - shop.c;
                break;
            case 2: // 상점이 남쪽
                distance += r - dong.r;
                if(dong.direction == 3) distance += shop.c;
                else distance += c - shop.c;
                break;
            case 3: // 상점이 서쪽
                if(dong.direction == 3) distance = Math.abs(dong.r - shop.r); // 같은 위치일 경우에 절대값 반환
                else{
                    int tmp1 = dong.r + c + shop.r;
                    int tmp2 = (r - dong.r) + c + (r - shop.c);
                    distance = Math.min(tmp1, tmp2);
                }
                break;
            default: // 남쪽일 경우
                if(dong.direction == 4) distance = Math.abs(dong.r - shop.r); // 같은 위치일 경우 절대값 반환
                else{
                    int tmp1 = dong.r + c + shop.r;
                    int tmp2 = (r - dong.r) + c + (r - shop.c);
                    distance = Math.min(tmp1, tmp2);
                }
                break;
        }
        result += distance;
    }

    static void setNorthAndSouth(Loc shop){ // 동근이의 위치가 가로축일때
        int distance = 0;

        switch (shop.direction){
            case 1:
                if(dong.direction == 1) distance = Math.abs(dong.c - shop.c);
                else{
                    int tmp1 = dong.c + r + shop.c;
                    int tmp2 = (c - dong.c) + r + (c - shop.c);
                    distance = Math.min(tmp1, tmp2);
                }
                break;
            case 2:
                if(dong.direction == 2) distance = Math.abs(dong.c - shop.c);
                else{
                    int tmp1 = dong.c + r + shop.c;
                    int tmp2 = (c - dong.c) + r + (c - shop.c);
                    distance = Math.min(tmp1, tmp2);
                }
                break;

            case 3:
                distance += dong.c;
                if(dong.direction == 1) distance += shop.r;
                else distance += r - shop.r;
                break;

            default:
                distance += c - dong.c;
                if(dong.direction == 1) distance += shop.r;
                else distance += r - shop.r;
                break;
        }
        result += distance;
    }

    static void setLocation(int tmp, int loc, int turn){ // 초기 위치를 설정하는 함수
        switch (tmp){
            case 1:
                shops[turn] = new Loc(0, loc, tmp);
                break;
            case 2:
                shops[turn] = new Loc(r-1, loc, tmp);
                break;
            case 3:

                shops[turn] = new Loc(loc, 0, tmp);
                break;
            default:
                shops[turn] = new Loc(loc, c-1, tmp);
                break;
        }

    }

    static void setDong(int tmp, int loc){ // 초기 위치를 설정하는 함수
        switch (tmp){
            case 1:
                dong = new Loc(0, loc, tmp);
                break;
            case 2:
                dong = new Loc(r-1, loc, tmp);
                break;
            case 3:
                dong = new Loc(loc, 0, tmp);
                break;
            default:
                dong= new Loc(loc, c-1, tmp);
                break;
        }
    }

    static class Loc {
        int r;
        int c;
        int direction;

        public Loc() {
        }

        public Loc(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
}


//10 10
//3
//4 6
//2 8
//1 4
//1 2

//10 5
//1
//3 2
//4 2

//20 20
//4
//4 6
//2 8
//1 9
//4 20
//2 7