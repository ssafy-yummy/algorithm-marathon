package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13335_S1_트럭 {
	
	static int n;
	static int w;
	static int l;
	static int[] trucks;
	
	static class Truck{
		
		int w;
		int curTime;
		public Truck() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Truck(int w, int curTime) {
			super();
			this.w = w;
			this.curTime = curTime;
		}
		@Override
		public String toString() {
			return "Truck [w=" + w + ", curTime=" + curTime + "]";
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		trucks = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(simulation());

	}

	private static int simulation() {

		int idx = 0;
		int time = 1;
		int curWeight = trucks[idx];
		ArrayList<Truck> arr = new ArrayList<>();
		arr.add(new Truck(trucks[idx],1));
		while(!arr.isEmpty()) {
			
//			for (Truck truck : arr) {
//				System.out.print(truck);
//			}
//			System.out.println("---------");
//			
			for (int i = 0; i < arr.size(); i++) {
				Truck t = arr.get(i);
				t.curTime += 1;
				if(t.curTime > w) {
					curWeight -= t.w;
					arr.remove(i--);					
				}
			}
			
			
			
			//추가로 트럭이 올라갈 수 있는지 검사
			if(idx+1 < n && curWeight+trucks[idx+1] <= l) {
				arr.add(new Truck(trucks[idx+1],1));
				curWeight += trucks[idx+1];
				idx++;
			}
			
			time++;
		}
		
		return time;
		
	}

}
