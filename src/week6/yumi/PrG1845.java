package week6.yumi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 프로그래머스 1845 포켓몬
 * 레벨1
 * 
 * 문제 : 홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
 * 		 홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다. 
 * 		 따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다.
 * 		 N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 
 * 		 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수
 * 
 * 핵심 : 중복 제거 - HashMap containsKey 사용 또는 HashSet 사용
 * 
 * HashMap이 HashSet 보다 빠른 이유
 * 
 * HashMap
 * : value가 고유 key와 연결되어 있어 HashSet 보다 빠름
 * 
 * HashSet
 * : 멤버 객체가 해시코드 값을 계산하는 데 사용되기 때문에 HashMap 보다 느림
 *    - key : Object
 *    - value : Object 내부 구현 코드에서 필드로 선언한 객체
 *    -> 해당 필드 객체의 해시값도 계산해야 하기 때문에 느림			
 * 
*/
public class PrG1845 {
	
	// 방법 1 : HashMap containsKey 사용
	// 		  - HashMap :해싱(hashing)기법으로 데이터를 저장하여 데이터가 많아도 검색이 빠르다.
	// 테스트 1 〉	통과 (0.03ms, 74.6MB)
	public int solution(int[] nums) {
		int max = nums.length/2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int num : nums) {
			if (map.containsKey(num)) {
				continue;
			}
			map.put(num, 1);
		}
		if (map.size() < nums.length/2) {
			max = map.size();
		}
		return max;
	}
	
	// 방법 2 : HashSet 사용 
	//		  - Set : 중복 허용 안 함
	// 테스트 1 〉	통과 (0.04ms, 77.2MB)
	public int solution2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int num : nums) {
			set.add(num);
		}
		if (set.size() < nums.length/2) {
			return set.size();
		}
		return nums.length/2;
	}
	
	public static void main(String[] args) {
		PrG1845 prg = new PrG1845();
		int[] nums = {3, 1, 2, 3};
		int[] nums2 = {3, 3, 3, 2, 2, 4};
		int[] nums3 = {3, 3, 3, 2, 2, 2};
		System.out.println(prg.solution(nums));
		System.out.println(prg.solution(nums2));
		System.out.println(prg.solution(nums3));
	}
}
