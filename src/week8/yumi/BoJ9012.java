package week8.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** 백준 9012 괄호
 * 실버4
 * 
 * 문제 : 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
 * 		 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 
 * 
 * 핵심 : ()쌍을 이루면 stack에서 (제거 
*/
public class BoJ9012 {
	// 방법1: stack 사용
	public String solution(String str) {
		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == ')') {
				// )가 더 많은 경우 
				if (stack.isEmpty()) {
					return "NO";
				}
				// ()쌍을 이루면 stack에서 (제거 
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		// (이 더 많은 경우
		if (!stack.isEmpty()) {
			return "NO";
		}
		return "YES";
	}
	
	// 방법2 : 개수로 확인
	public String solution2(String str) {
		int cnt = 0;
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				cnt++;
			} else if (cnt == 0) {
				// )가 더 많은 경우 
				return "NO";
			} else {
				cnt--;
			}
		}
		// (이 더 많은 경우
		if (cnt != 0) {
			return "NO";
		}
		return "YES";
	}
	
	public static void main(String[] args) throws IOException {
		BoJ9012 boj = new BoJ9012();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		while (n-- > 0) {
			sb.append(boj.solution2(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}
}
