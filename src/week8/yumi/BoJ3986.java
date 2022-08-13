package week8.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** 백준 3986 좋은 단어
 * 실버4
 * 
 * 문제 : 단어 위로 아치형 곡선을 그어 같은 글자끼리(A는 A끼리, B는 B끼리) 쌍을 짓기로 하였다. 
 * 		 만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을수 있다면, 그 단어는 '좋은 단어'이다. 
 * 		 평석이가 '좋은 단어' 개수를 세는 것을 도와주자.
 * 
 * 핵심 : 문자가 다르면 stack에 쌓음 - ABABBABA인 경우 고려
 * 		짝이 안 맞는 경우 또는 교차할 경우 > 0
*/
public class BoJ3986 {
	
	public int solution(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : str.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(ch);
			} else if (stack.peek() != ch) {
				// 문자가 다르면 stack에 쌓음 - ABABBABA인 경우 고려
				stack.push(ch);
			} else {
				// 동일문자면 짝을 이룸으로 stack에서 제거
				stack.pop();
			}
		}
		// 짝이 안 맞는 경우 또는 교차할 경우
		if (stack.size() > 0) {
			return 0;
		}
		// 좋은 단어
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ3986 boj = new BoJ3986();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (n-- >0) {
			cnt += boj.solution(br.readLine());
		}
		System.out.println(cnt);
	}

}
