package week2.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 백준 1371 가장 많은 글자
 * 브론즈1
 * 
 * 문제 간단 설명 : 가장 많이 나온 글자를 출력 (각 줄에는 공백과 알파벳 소문자만 있다)
 * 
 * 핵심 : 알파벳별 개수 세기 - int[26]
 */
public class BoJ1371 {
	static int[] cntArr = new int[26];
	
	// 방법 1 : 알파벳별 사용 개수 세기 - toCharArray(), isAlphabetic() 사용 
	static void solution(String str) {
		for (char ch : str.toCharArray()) {
			if (!Character.isAlphabetic(ch)) {
				continue;
			}
			// 알파벳 개수++
			cntArr[ch-'a']++;
		}
	}
	
	// 방법 2 : 알파벳별 사용 개수 세기 - charAt() 사용 
	static void solution2(String str) {
		for (int i=0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				// 알파벳 개수++
				cntArr[ch-'a']++;
			}
		}
	}
	
	public static String calc() {
		StringBuilder sb = new StringBuilder();
		int max = 0;
		
		for (int i = 0; i < cntArr.length; i++) {
			if (max > cntArr[i]) {
				continue;
			}
			// max 재설정, 답 초기화
			if (max < cntArr[i]) {
				max = cntArr[i];
				sb.delete(0, sb.length()); // 초기화 방법 1
				//sb.setLength(0); // 초기화 방법 2
			}
			sb.append((char)(i+'a'));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while ((str = br.readLine()) != null) {
			solution(str);
		}
		br.close();
		System.out.println(calc());
	}
}
