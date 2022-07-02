package week2.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 백준 1411 비슷한 단어
 * 실버3
 * 
 * 문제 간단 설명 : 비슷한 단어 개수 세기
 * 				1. 단어 A에 등장하는 모든 알파벳을 다른 알파벳으로 바꾼다
 * 				2. 두 개의 다른 알파벳을 하나의 알파벳으로 바꿀 수 없다
 * 				3. 자기 자신으로 바꾸는 것은 가능하다.
 * 				4. 모든 단어의 길이는 같고, 중복되지 않는다. 알파벳 소문자로 이루어진다
 * 
 * 핵심 : Map을 사용해 key - value 로 관리
 * 		1. 기준값(key)이 매핑된 적이 있으면 안됨 - 잘못된 예) bb - ac
 * 		2. value 또한 이미 다른 키와 매칭된 적이 있으면 안됨 - 잘못된 예) ab - bb
 * 		3. 비슷한 '쌍'을 구하는 것임
*/
public class BoJ1411 {
	
	static int solution(List<String> li) {
		int cnt = 0;
		for (int i = 0; i < li.size(); i++) {
			for (int j = i+1; j < li.size(); j++) {
				// 비슷한 문자열이 있다면 개수 ++
				if (isSim(li.get(i), li.get(j))) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static boolean isSim(String str1, String str2) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < str1.length(); i++) {
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			// 기준 키가 매핑된 문자가 없을 시 추가
			// ab - cd / ab - bb
			if (!map.containsKey(ch1)) {
				// 이미 매핑된 적이 있는 경우
				if(map.containsValue(ch2)) {
					return false;
				}
				// 키 벨류 매핑
				map.put(ch1, ch2);
				continue;
			}
			// 매핑된 문자와 동일하지 않은 경우 다른 단어로 간주
			if (map.get(ch1) != ch2) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<String> li = new ArrayList<String>();
		while (t-- > 0) {
			li.add(br.readLine());
		}
		System.out.println(solution(li));
	}
}
