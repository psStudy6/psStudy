/**
 * 문제 제목 : 012. 암호
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
package main;

import java.util.Scanner;

public class IjC112 {
	public static void main(String[] args) {
		IjC112 M = new IjC112();
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();
		String x = in.next();
		in.close();
		System.out.println(M.solution(c, x));
	}

	public String solution( int c, String x ) {
		int numbering = c;
		String answer = "";

		/*
		 * 노가다식 데이터 방법
		 * strArr[0] = x.substring(0, 6);
		 * strArr[1] = x.substring(7, 13);
		 * ...
		*/

		// ChackPoint1. 알파벳 한 문자마다 # 또는 *이 일곱 개 구성
		for(int i=0; i<numbering; i++ ) {
			// ChakPoint2. #은 이진수의 1로, *이진수의 0으로 변환
			String num = x.substring((i*7), (i*7+7)).replace("#", "1").replace("*", "0");
			// System.out.println(x.substring((i*7), (i*7+7))); 									 - test : 데이터 체크
			// System.out.println(x.substring((i*7), (i*7+7)).replace("#", "1").replace("*", "0"));	 - test : 데이터 체크

			// ChackPoint3. 2진수를 10진수화 변환 및 아스키코드로 전환
			answer += (char)Integer.parseInt(num, 2);
		}
		return answer;
	}
}

// ========================================================================= //

// 강의 내용1

import java.util.*;

public class Main {
  public String solution(int n, String s) {
    String answer = "";
    for(int i=0; i<n; i++) {
      STring temp=s.substring(0,7).replace("#", "1").replace("*","0");
      int num = Integer.paeseInt(tmp, 2);
      answer+=(char) num;
      s=s.substring(7);
    }
    return answer;
  }
    
  public static void main(String[] args) {
    Main T = new new Main();
    Scanner kb = new Scanner(System.in);
    int n= kb.nextInt();
    String str = kb.next();
    System.out.println(T.solution(n,str));
  }
}  
