/**
 * 등록 번호 : 6571번  
 * 등록 제목 : 피보나치 수의 개수
 * 현재 상태 : 미완료 ⚠️
 */
package main;

import java.util.Scanner;

public class BoJ6571 {

	public static void main(String[] args) {
		BoJ6571 M = new BoJ6571();
		Scanner in = new Scanner(System.in);
		long min = 0;
		long max = 0;
		
		while(in.hasNextLong()) {
			min = in.nextLong();
			max = in.nextLong();
			
			if(min != 0 || max != 0) {
				System.out.println(M.solution(min, max));
			}
			else {
				break;
			}
		}
		in.close();
		// CheckPolong1. 0 0이 들어왓을 때 바로 탈출
	}
	
	public int solution(long min, long max){
		int answer = 0;
		
		// CheckPoint2. 피보나치 공식
		long[] pivo = new long[100];
		pivo[0] = 1;
		pivo[1] = 2;
	
        // CheckPoint3. 피보나치 수열값 초기화
		for(long i=2; i<pivo.length; i++) {
			pivo[(int) i] = pivo[(int) (i-1)] + pivo[(int) (i-2)];
		}
        
		// CheckPoint3. 해당되는 결과값 길이 출력
		for(long i=0; i<pivo.length; i++) {
			// System.out.println(pivo[(int) i]);
			if(pivo[(int) i] >= min && pivo[(int) i] <= max) {
				answer++;
			}
		}
		return answer;
	}
}
