package week15.yumi;

import java.util.Arrays;

/** 프로그래머스 42885 구명보트
 * 탐욕법(Greedy)
 * 
 * 문제 : 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
 * 		구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
 * 		사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
 * 		모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 핵심 : 투포인터
*/

public class PrG42885 {
	public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int pointer = 0;
        
        for (int backPointer = people.length - 1; backPointer > pointer; backPointer--) {
			if (people[pointer] + people[backPointer] <= limit) {
				pointer++; // 가장 가벼운 사람 & 가장 무거운 사람 2명 탑승
			} // 두명의 합이 제한보다 크면 가장 무거운 사람만 탑승
			cnt++; // 최대 2명 제한이므로 항상 카운트
		}
        return cnt;
    }
	
	public static void main(String[] args) {
		PrG42885 prg = new PrG42885();
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(prg.solution(people, limit));
	}
}
