/**
 * 문제 제목 : 011. 문자열 압축
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)  - 강의 풀이랑 동일한 로직(?)
package main;

import java.util.Scanner;

public class IjC111 {

	public static void main(String[] args) {
		IjC111 M = new IjC111();
		Scanner in = new Scanner(System.in);

		String X = in.next();
		in.close();
		System.out.println(M.solution(X));
	}

	public String solution(String X) {
		String x = X + " ";
		String answer = "";

		int cnt = 1;
		for(int i=0; i<x.length()-1; i++) {
			if(x.charAt(i) == x.charAt(i+1)) cnt++;
			else {
				answer += x.charAt(i);
				if(cnt>1) answer += String.valueOf(cnt);
				cnt = 1;
			 }
		}
		return answer;
	}

}

// ====================================================================== //

// 강의내용1
import java.util.*;

public class IjC111 {

	public static void main(String[] args) {
		IjC111 M = new IjC111();
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		System.out.println(M.solution(s));

	}

	public String solution(String s) {
		String answer = "";
		s = s + " ";
		int cnt = 1;
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) cnt++;
			else {
				answer += s.charAt(i);
				if(cnt>1) answer += String.valueOf(cnt);
				cnt = 1;
			 }
		}
		return answer;
	}

}
