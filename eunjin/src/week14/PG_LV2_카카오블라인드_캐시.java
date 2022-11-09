package week14;

import java.util.ArrayList;
import java.util.List;

class PG_LV2_카카오블라인드_캐시 {
    
	static class City implements Comparable<City> {
		int inputTime;
		String cityName;

		public City(int inputTime, String cityName) {
			super();
			this.inputTime = inputTime;
			this.cityName = cityName;
		}

		@Override
		public int compareTo(City o) {
			return this.inputTime - o.inputTime;
		}
	}
	static int cacheSize, time, ans;
	static String[] cities;
	static List<City> cacheArr;
	
	public static void main(String[] args) {
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
	}
    
    public static int solution(int cacheSize2, String[] cities2) {
        cacheSize = cacheSize2;
        cities = cities2;
        
        if(cacheSize==0) {	// 예외처리
			return cities.length*5;
		}
		
		cacheArr = new ArrayList<>();
		time = 0;
		for (String city : cities) {
			time++;
			find(time, city.toLowerCase());	// 도시의 이름은 대소문자를 구분하지 않는다.
		}
        return ans;
    }
    
    private static void find(int time, String city) {
        try{
		int n = cacheArr.size();
		for (int i = 0; i < n; i++) {
			if (cacheArr.get(i).cityName.equals(city)) { // 1-1. cache hit일 경우,
				cacheArr.get(i).inputTime = time; // 1-2. 시간 업데이트
				ans += 1;
				return;
			}
		}

		// 2-1. cache miss일 경우,
		if(cacheArr.size()<cacheSize) {
			cacheArr.add(new City(time, city));
		} else {
			cacheArr.sort(null);// 2-2. LRU를 위해 가장 오래 전에 접근한 캐시를 바꾼다.
			cacheArr.get(0).inputTime = time;
			cacheArr.get(0).cityName = city;
		}
		ans += 5;
		return;
        } catch (Exception e){
            System.out.println(cacheArr.size()+" "+cacheSize);
        }
	}
}