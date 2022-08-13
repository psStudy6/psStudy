package week8.ram;
import java.util.*;
import java.io.*;
/* 괄호문자제거 
 * Stack(스택) 이용
 */
public class IjC502 {
	public String solution(String str) {
		String ans = "";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(x==')') {
				while(stack.pop()!='(');//이전 괄호까지 있는 모든 문자를 삭제
				
			}
			else stack.push(x);//괄호가 아니면 계속 스택에 문자를 넣어줌
		}
		for(int i=0;i<stack.size();i++) ans+=stack.get(i);
		
		return ans;
		
	}
	public static void main(String[] args) {
		IjC502 T = new IjC502();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
		
	}

}
