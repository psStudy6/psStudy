package week2.yumi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** 백준 3447 버그왕
 * 브론즈1
 * 
 * 문제 간단 설명 : 버그가 있을 시 BUG로 바꿔버린다.
 * 				버그 찾는 프로그램이 처리한 결과가 주어졌을 때, BUG를 모두 없애는 프로그램
 * 				입력으로 주어진 소스 코드의 BUG를 모두 제거한 뒤 출력한다 (ABUBUGGB -> AB)
 *  
 * 핵심 : 1. replaceAll()
 * 		 2. BUG를 공란으로 대체 시 새로운 BUG 문자가 발생하는 경우 고려 - 재귀함수 / while(true)
*/
public class BoJ3447 {
	
	// 방법 1 : 재귀함수 & contains 사용
	static String solution(String str) {
		String answer = str.replaceAll("BUG", "");
		// 재귀함수로 BUG 없을 때 까지 진행
		// ABUBUGGB -> ABUGB -> AB
		if (answer.contains("BUG")) {
			answer = solution(answer);
		}
		return answer;
	}
	
	// 방법 2 : while & equals 사용 
	static String solution2(String str) {
		while (true) {
			if (str.equals(str.replaceAll("BUG", ""))) {
				break;
			}
			str = solution(str.replaceAll("BUG", ""));
		}
		return str;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = "";
		while ((str=br.readLine()) != null) {
			bw.append(solution(str)).append("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
