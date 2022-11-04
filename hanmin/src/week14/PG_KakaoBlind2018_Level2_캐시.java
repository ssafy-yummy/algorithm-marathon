package hanmin.src.week14;

import java.util.*;
import java.util.List;

class PG_KakaoBlind2018_Level2_캐시 {

	public static void main(String args[]) throws Exception {
	}

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		int cnt = 1;
		// string을 int로 변경
		Map<String, Integer> m = new HashMap<>();
		List<Integer> cache = new LinkedList<>();
		// 캐시에 있는지 확인
		int[] isCache = new int[cacheSize];
		for (int i = 0; i < cities.length; ++i) {
			String city = cities[i].toUpperCase();

			// string을 int로 변경
			if (!m.containsKey(city))
				m.put(city, cnt++);

			int num = m.get(city);
			// 캐시에 없는 경우
			if (cache.isEmpty() || isCache[num] == 0) {
				//캐시에서 삭제 후 맨뒤에 추가
				if (cache.size() == cacheSize) {
					isCache[cache.get(0)] = 0;
					cache.remove(0);
				}
				answer += 5;
			}
			// 캐시에 있는 경우
			else {
				// 캐시찾아서 삭제 맨뒤에 추가
				cache.remove(cache.indexOf(num));
				answer += 1;
			}
			// 캐시에 넣을 수 있다면
			if (cache.size() < cacheSize) {
				isCache[num] = 1;
				cache.add(num);
			}
		}
		return answer;
	}

}

class LRU<K, V> extends LinkedHashMap<K, V> {
	private int size;

	private LRU(int size) {
		super(size, 0.75f, true);
		this.size = size;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > size;
	}

	public static <K, V> LRU<K, V> newInstance(int size) {
		return new LRU<K, V>(size);
	}
}