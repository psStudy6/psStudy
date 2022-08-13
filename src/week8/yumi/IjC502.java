package week8.yumi;

import java.util.Scanner;
import java.util.Stack;

/** 인프런 5-2 괄호문자 제거
 * 
 * 문제 :입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램
 * 
 * 핵심 : (가 있으면 stack에 넣고 )가 나올때까지 문자 저장 안 함
 * 		 (가 없는 경우 stack.empty() 일때만 문자 저장
*/
public class IjC502 {
	
	// 방법 1 : (가 있으면 stack에 넣고 )가 나올때까지 문자 저장 안 함
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for (char ch : str.toCharArray()) {
			if (ch == ')') {
				stack.pop();
			} else if (ch == '('){
				stack.push(ch);
			} else if (stack.empty()) {
				sb.append(ch);
			}
		}
		System.out.println(sb);
		sc.close();
	}
	
	// 방법2 : stack에 모든 문자 넣은 후 )가 나오면 (일때까지 stack.pop()
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for (char ch : str.toCharArray()) {
			if (ch == ')') {
				while (stack.pop() != '(');
			} else {
				stack.push(ch);
			}
		}
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb);
		sc.close();
	}
}
