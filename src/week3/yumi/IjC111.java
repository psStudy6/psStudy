package week3.yumi;

import java.util.Scanner;

/** 인프런 1-11 문자열 압축
 *  
 *  문제 간단 설명 : 알파벳 대문자로 이루어진 문자열
 *  			같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법
 *  			단 반복횟수가 1인 경우 생략
 *  
 *  핵심 : 마지막 문자 확인 위해 " " 추가
*/
public class IjC111 {

	// 방법 1 : for문, toCharArray 사용
	static String solution(String str) {
		StringBuffer sb = new StringBuffer(); 
		char prev = '\0';
		int cnt = 0;
		str += " ";
		
		for (char ch : str.toCharArray()) {
			if (prev != ch) {
				if(cnt > 1) {
					sb.append(cnt);
				}
				sb.append(ch);
				prev = ch;
				cnt = 0;
			}
			cnt++;
		}
		return sb.toString();
	}
	
	// 방법 2 : for문, charAt 사용
	static String solution2(String str) {
		StringBuilder sb = new StringBuilder();
		str += " ";
		int cnt = 1;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				cnt++;
				continue;
			}
			sb.append(str.charAt(i));
			if (cnt > 1) {
				sb.append(cnt);
				cnt = 1;
			}
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
	}

}
