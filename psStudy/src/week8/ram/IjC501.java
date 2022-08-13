package week8.ram;
import java.util.*;
import java.io.*;
/* 올바른 괄호
 * 괄호의 쌍이 올바른 지 탐색
 */
public class IjC501 {
	public static String solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c =='(') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) {//닫는 괄호가 더 많다면
					return "NO";
				}
				stack.pop();
			}
		}
		if(!stack.isEmpty()) {//여는 괄호가 더 많다면
			return "NO";
			
		}
		return "YES";
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(br.readLine()));
		
	}

}
