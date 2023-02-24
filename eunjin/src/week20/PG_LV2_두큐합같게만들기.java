package week20;

import java.util.Arrays;

public class PG_LV2_두큐합같게만들기 {

    static int map[][];
    static int dd[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(solution(rows,columns,queries)));
	}
    
    public static int[] solution(int rows, int columns, int[][] queries) {
        makeMap(rows, columns); // map[][] 전역변수 생성

        int n = queries.length;
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = moveAndFind(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        return answer;
    }
    
    static void makeMap(int rows, int columns) {
        map = new int[rows][columns];
        for(int i=0,k=1; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = k++;
            }
        }
    }
    static int moveAndFind(int x1, int y1, int x2, int y2) {
        int r = x1;
        int c = y1;
        int d = 0;
        int temp = map[r][c];
        int minValue = map[r][c];
        while(d<4) {	// 반시계 방향으로 돌면서 값을 돌려 바꿔준다
            int nr = r+dd[d][0];
            int nc = c+dd[d][1];
            if((nr==x1||nr==x2)&&(nc==y1||nc==y2)) d++;	// 모서리에 닿으면 방향을 꺾
            map[r][c] = map[nr][nc];
            r = nr;
            c = nc;
            
            if(map[r][c] < minValue) minValue = map[r][c];
        }
        map[x1][y1+1] = temp;
        return minValue;
    }
}