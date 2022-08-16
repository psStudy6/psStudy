package week8.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** 인프런 5-4 후위식 연산(postfix)
 *  
 * 문제 : 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 		 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 * 
 * 핵심 : 후위연산이므로 b 연산 a 이어야 함
 * 		 3) 3| 
 * 		 5) 3|5|
 * 		 2) 3|5|2|
 * 		 +) 5+2 = 7 -> 3|7|
 * 		 *) 3*7 = 21 -> 21|
 * 		 9) 21|9
 * 		 -) 21-9 = 12
*/
public class IjC504 {
	// 사칙연산 - 후위연산이므로 b 연산 a 이어야 함
	public int cal(int a, int b, char ch) {
		if (ch == '+') {
			return b + a;
		}
		if (ch == '-') {
			return b - a;
		}
		if (ch == '*') {
			return b * a;
		}
		if (ch == '/') {
			return b / a;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		IjC504 ijC = new IjC504();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		char[] arr = br.readLine().toCharArray();
		int tot = 0;
		for (char ch : arr) {
			if (Character.isDigit(ch)) {
				stack.push(Character.getNumericValue(ch));
				continue;
			}
			tot = ijC.cal(stack.pop(), stack.pop(), ch);
			stack.push(tot);
		}
		System.out.println(tot);
		br.close();
	}
}
