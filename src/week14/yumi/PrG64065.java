package week14.yumi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** 프로그래머스 64065 튜플 
 * 2019 카카오 개발자 겨울 인턴십
 * 
 * 핵심 : 집합은 a1부터 a1,a2 -> a1,a2,..,an 순서로 생김
 * 		-> 제일 많이 나온 숫자 = a1 / 제일 적게 나온 숫자 = an
 * 		map(숫자, 횟수)
*/
public class PrG64065 {
	
	public int[] solution(String s) {
        s = s.replaceAll("[\\{\\}]", ""); // { 와 } 제거하여 숫자만 남김
        String[] arr = s.split(",");
        Map<String, Integer> map = numbers(arr); // map(숫자, 횟수)
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 횟수 내림차순 정렬
        Collections.sort(list, (o1, o2) -> {return o2.getValue().compareTo(o1.getValue());});
        
        int[] answer = new int[map.size()];
        int i = 0;
        // 배열에 담기
        for (Entry<String, Integer> entry : list) {
        	String number = entry.getKey();
			answer[i] = Integer.parseInt(number);
			i++;
		}
        return answer;
    }
	
	private Map<String, Integer> numbers(String[] arr) {
		Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
        	// 집합은 a1부터 a1,a2 -> a1,a2,..,an 순서로 생김
        	// -> 제일 많이 나온 숫자 = a1 / 제일 적게 나온 숫자 = an
        	// map(숫자, 횟수)
            if (map.containsKey(arr[i])){
            	map.replace(arr[i], map.get(arr[i]) + 1);
            }else{
            	map.put(arr[i], 1);
            }
        }
        return map;
	}

	public static void main(String[] args) {
		PrG64065 prg = new PrG64065();
		//String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		//String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		//String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] arr = prg.solution(s);
		System.out.println(Arrays.toString(arr));
	}

}
