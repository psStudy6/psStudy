
/**
 * 프로그래머스
 * 등록 번호 : 1845번  
 * 등록 제목 : 포켓몬
 * 현재 상태 : 완료 ✔️
 */
import java.util.*;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
		int number = nums.length/2;

		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			set.add(nums[i]);
		}
      
		if(number < set.size()) {
      answer = number;
    }	else {
      answer = set.size();
    }
		return answer;
    }
}
