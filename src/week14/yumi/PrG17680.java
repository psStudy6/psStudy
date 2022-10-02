package week14.yumi;

import java.util.LinkedList;

/** 프로그래머스 17680 캐시
 * 2018 KAKAO BLIND RECRUITMENT
 * 
 * 조건 : 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용
 * 
 * 용어 설명)
 * LRU : 가장 오랜동안 사용하지 않은 캐시 먼저 제거
 * 
 * Cache Miss : 해야할 작업이 캐시에 없는 상태
 * 			 캐시 크기 초과 시 제일 오래된 캐시 제거.
 * 			 한칸 씩 밀고 제일 앞에 캐시 추가
 * 			 ex) 3,2,1,6,7 -> 5,3,2,1,6
 * 
 * Cache Hit : 해야할 작업이 캐시에 있는 상태
 * 			제일 앞으로 옮기고 앞에 있던 캐시 한칸 씩 뒤로 밀림
 * 			ex) 3,2,1,6,7 -> 1,3,2,6,7 
*/
public class PrG17680 {
	
	public int solution(int cacheSize, String[] cities) {
		// 캐시 크기가 0일 경우 계속 Cache Miss 이므로 길이 * 5초
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		int sec = 0;
		LinkedList<String> cache = new LinkedList<>();
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			// Cache Hit : 해야할 작업이 캐시에 있는 상태 + 1초
			if (cache.remove(city)) {
				sec += 1;
				cache.add(city);
			} else { // Cache Miss : 해야할 작업이 캐시에 없는 상태 + 5초
				sec += 5;
				// 캐시 크기 넘을 시
				if (cache.size() >= cacheSize) {
					// list 순서 유지함 - 제일 앞 삭제 시 그다음 순서가 인덱스 0임
					cache.remove(0);
				}
				cache.add(city);
			}
		}
		return sec;
	}
	
	public static void main(String[] args) {
		PrG17680 prg = new PrG17680();
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(prg.solution(cacheSize, cities));
	}
}
