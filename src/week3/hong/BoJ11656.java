/**
 * 등록 번호 : 11656번  
 * 등록 제목 : 접미사 배열
 * 현재 상태 : 완료 ✔️
 */

package main;

import java.util.Arrays;
import java.util.Scanner;

public class BoJ11656 {

	public static void main(String[] args) {
		BoJ11656 M = new BoJ11656();
		Scanner in = new Scanner(System.in);
		
		String X = in.next();
		in.close();
		System.out.println(M.solution(X));
	}
	
	public String solution(String X) {
		String[] arr = new String[X.length()];
		String answer = "";
		
    // CheckPoint1. 0 ~ X길이 자르고 배열에 담기
		for(int i=0; i<X.length(); i++) {
			arr[i] = X.substring(i, X.length());
		}
    // CheckPoint2. X길이 짜른 배열 정렬
		Arrays.sort(arr);
		
		for(String str : arr) {
			answer += str + "\n";
		}
		return answer;
	}

}
