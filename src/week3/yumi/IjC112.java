package week3.yumi;

import java.util.Scanner;

/** 인프런 1-12 암호
 * 
 * 문제 간단 설명 : 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성
 * 				1. #*****# -> 일곱자리의 이진수 (#은 이진수의 1로, *은 이진수의 0)
 * 				2. 2진수 -> 10진수화
 * 				3. 아스키 번호 -> 65문자로 변환
 * 
 * 핵심 : replaceAll() 사용 시 특수문자 치환 : //특수문자 - 인자값으로 정규식 받기 떄문
 * 		 replace() 사용 시 : 정규식으로 받지 않기 때문에 특수문자 별도 처리할 필요 없음
 * 		 문자열2진수-10진수화 : Integer.parseInt(문자열, 2) 또는 Integer.valueOf(문자열, 2)
 * 		 아스키번호-65문자 : (char) 캐스팅
*/
public class IjC112 {
	// 방법 1: substring(), valueOf(, 2), (char) 사용
	static String solution(int n, String str) {
		StringBuffer sb = new StringBuffer();
		// replaceAll() 사용
		str = str.replaceAll("\\#", "1").replaceAll("\\*", "0");
		
		for (int i = 1; i <= n; i++) {
			// 7자리의 2진수
			String tmp = str.substring((i-1)*7, i*7);
			// 10진수
			int ascii = Integer.valueOf(tmp, 2);
			// 문자
			sb.append((char) ascii);
		}
		return sb.toString();
	}
	
	// 방법 2: substring(), Integer.parseInt(, 2), (char) 사용
	static String solution2 (int n, String str) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= n; i++) {
			// 7자리의 2진수, replace() 사용
			String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
			System.out.println(">>"+tmp);
			// 10진수
			int num = Integer.parseInt(tmp, 2);
			// 문자
			sb.append((char)num);
			str = str.substring(7);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println(solution2(n, str));
	}
}
