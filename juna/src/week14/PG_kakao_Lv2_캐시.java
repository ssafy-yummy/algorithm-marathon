package algorithm;

import java.util.HashMap;
import java.util.Map;

class PG_kakao_Lv2_캐시 {
	public int solution(int cacheSize, String[] cities) {
        
        // 캐시 사이즈가 0이라면, 모든 도시들은 cache miss이다.
        if (cacheSize == 0) return 5 * cities.length;
        
        int answer = 0;
        String[] cache = new String[cacheSize];		// 캐시 배열
        int[] time = new int[cacheSize];			// time[i] 의미 : cache[i]가 제일 최근에 사용된 시각
        Map<String, Integer> map = new HashMap<>();	// city(key)가 캐시의 몇 번째 인덱스(value)에 들어있는지
        
        int t = 0;
        
        for (String city : cities) {
        	
        	t++;						// 시간 증가
        	int idx = 0;				// cache의 몇 번째 인덱스에 city를 넣을 것인가
        	city = city.toLowerCase();	// city를 소문자로 바꿔주고 시작하기
        	
        	
        	// 1. 이미 캐시 안에 city가 들어 있는가?	-> hit!
        	if (map.containsKey(city)) {
        		answer += 1;
        		idx = map.get(city);	
				time[idx] = t;
        	}
        	
        	
        	// 2. 캐시 안에 city가 없다 -> miss!
        	else {
        		answer += 5;
        		
        		// 2-1) 비어있는 캐시가 있는가?
        		if (map.size() < cacheSize) {
        			idx = map.size();
        			time[idx] = t;
        			map.put(city, idx);
        		}
        		
        		// 2-2) 비어있는 캐시가 없다면, 제일 최근에 사용된 적 없는 캐시를 대체하기
        		else {
        			// 제일 최근에 사용된 적 없는 캐시를 찾기
        			int min = Integer.MAX_VALUE;
        			for (int i = 0; i < cacheSize; i++) {
						if (min > time[i]) {
							idx = i;
							min = time[i];
						}
					}
        			
        			map.remove(cache[idx]);
        			map.put(city, idx);
        			time[idx] = t;
        		}
        	}
        	
        	// 찾은 idx 위치에 city 넣기
        	cache[idx] = city;
		}
        
        return answer;
    }
}