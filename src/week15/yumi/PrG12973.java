package week15.yumi;

import java.util.Stack;

/** 프로그래머스 12973 짝지어 제거하기
 * 
*/
public class PrG12973 {
	
	public int solution(String s) {
        Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// 짝 찾은 경우
			if(!stack.empty() && stack.peek() == ch) {
				stack.pop();
			} else { // 다음 문자 추가
				stack.push(ch);
			}
		}
        return stack.size() == 0 ? 1 : 0;
    }
	
	public static void main(String[] args) {
		PrG12973 prg = new PrG12973();
		System.out.println(prg.solution("cdcd"));
	}
}
