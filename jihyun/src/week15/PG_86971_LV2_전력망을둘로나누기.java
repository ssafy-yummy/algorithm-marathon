package week15;

public class PG_86971_LV2_전력망을둘로나누기 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        Solution s = new Solution();
        int result = s.solution(n, wires);
        System.out.println(result);
    }
}

class Solution {
	static int[] parents;
	
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            answer=Math.min(answer,unionFind(n, wires, i));
        }

        return answer;
    }

    private static int unionFind(int n, int[][] wires, int ec) {

        parents = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < wires.length; i++) {
            if (i == ec)
                continue;
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            union(a,b);

            

        }
        //System.out.println(Arrays.toString(parents));

        int p = find(parents[1]);
        int count = 0;
        for(int i=1;i<n+1;i++) {
        	if(find(parents[i])==p)
        		count++;
        }
        //System.out.println(n+" "+count+" "+(n-count));
        return Math.abs(count-(n-count));

    }

    private static void union(int a, int b) {
    	int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return;

        if (aRoot > bRoot)
            parents[aRoot] = bRoot;

        else
            parents[bRoot] = aRoot;
		
	}

	private static int find(int x) {
        if (parents[x] != x)
            return find(parents[x]);
        
        return x;
    }
}