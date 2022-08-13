package week8.ram;
import java.util.*;
import java.io.*;
/* 좋은 단어
 * 모든 글자가 A와 B로 change
 * 같은 글짜끼리 아치형 곡선으로 연결
 * 곡선끼리 겹치지 않으면서 쌍이 만들어 지면
 * '좋은 단어'
 */

public class BoJ3986{
	/* solution
	 * 단어 하나를 stack에 push
	 * 
	 */
	static int count = 0;
	public static void solution(String str) {
		Stack<Character> st = new Stack<>();
		if(str.length()%2 == 1) return ; //문자열의 길이가 홀수이다는 것은 A 또는 B의 개수가 홀수이므로 좋은 단어가 아니다.
		else {
			st.push(str.charAt(0)); //첫 단어는 스택에 push
			for(int i=1;i<str.length();i++) {
				if(st.size()>0 && st.peek()==str.charAt(i)) {
					st.pop();
				}
				else st.push(str.charAt(i));
				if(st.isEmpty()) count++;
			}
		return ;
		}
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			solution(str);
		}
		System.out.println(count);
	}

}
