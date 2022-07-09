import java.util.*;
//아스키 코드
//A~Z : 65~90
//a~z : 97~122

public class BOJ11655 {
	public String solution(String str) {
		String answer="";
		char ch;
		for(int i=0;i<str.length();i++) {
			ch = str.charAt(i);
			if(ch>='A'&&ch<='M') {
				answer=answer+(char)((int)ch+13);
			}
			else if(ch>='N'&&ch<='Z') {
				answer=answer+(char)((int)ch+13-26);
			}
			else if(ch>='a'&&ch<='m') {
				answer=answer+(char)((int)ch+13);
			}
			else if(ch>='n'&&ch<='z') {
				answer=answer+(char)((int)ch+13-26);
			}
			else
				answer=answer+ch;
		}
		return answer;
	}

	public static void main(String args[]) {
		BOJ11655 T = new BOJ11655();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(T.solution(str));
		
	}
}
