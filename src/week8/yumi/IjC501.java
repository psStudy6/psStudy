package week8.yumi;

import java.util.Scanner;
import java.util.Stack;

/** 인프런 5-1 올바른 괄호
 * 
 * 문제 : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * 		 (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 * 
 * 핵심 : -
 * 
*/
public class IjC501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		String answer = "YES";
		for (char ch : str.toCharArray()) {
			if (ch == ')') {
				if (stack.empty()) {
					answer = "NO";
					break;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
