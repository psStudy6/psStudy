package week3.yumi;

import java.util.Scanner;

/** 백준 11655 ROT13
 * 브론즈1
 * 
 * 문제 : ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
 * 		ROT13은 알파벳 대문자와 소문자에만 적용할 수 있다. 
 * 		알파벳이 아닌 글자는 원래 글자 그대로 남아 있어야 한다. 
 * 		문자열이 주어졌을 때, "ROT13"으로 암호화한 다음 출력
 * 
 * 핵심 : 13을 더하면 대문자 또는 소문자 영역을 넘어설 경우 고려
*/
public class BoJ11655 {
	public String solution(String str) {
		StringBuffer sb = new StringBuffer();
		for (char ch : str.toCharArray()) {
			// 알파벳이 아닐 경우 그대로 출력
			if (!Character.isAlphabetic(ch)) {
				sb.append(ch);
				continue;
			}
			// 알파벳일 때 아스키코드 13 더함
			char tmp = (char)(ch + 13);
			char start = Character.isUpperCase(ch) ? 'A' : 'a';
			char end = Character.isUpperCase(ch) ? 'Z' : 'z';
			// 13을 더하면 대문자 또는 소문자 영역을 넘어설 경우
			if (tmp > end) {
				// 알파벳 영역 시작점 + 알파벳 끝점-13더한값-1
				tmp = (char)(start+Math.abs(end-tmp)-1);
			}
			sb.append(tmp);
		}
		return sb.toString();
	}
	
	public String solution2(String str) {
		StringBuffer sb = new StringBuffer();
		// 아스키코드 값으로 반복문
		for (int ch : str.toCharArray()) {
			// 알파벳이 아닐 경우 그대로 출력
			if (!Character.isAlphabetic(ch)) {
				sb.append((char)ch);
				continue;
			}
			// 알파벳일 때 아스키코드 13 더함
			ch += 13; 
			// 13을 더하면 대문자 영역을 넘어설 경우
			// 알파벳 영역 시작점 + 알파벳 끝점-13더한값-1
			if (Character.isUpperCase(ch) && ch > 'Z') {
				ch = ch-'Z'+'A'-1;
			} 
			if (Character.isLowerCase(ch) && ch > 'z') {
				ch = ch-'z'+'a'-1;
			} 
			sb.append((char)ch);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		BoJ11655 boJ = new BoJ11655();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		System.out.println(boJ.solution(str));
	}
}
