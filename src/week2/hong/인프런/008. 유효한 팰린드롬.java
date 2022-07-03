/**
 * 문제 제목 : 008. 유효한 팰린드롬
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main M = new Main();
		Scanner in = new Scanner(System.in);

		String X = in.next();
		in.close();

		System.out.println(M.solution(X));
	}

	public String solution(String X) {
		char[] arr = X.toLowerCase().toCharArray();
		String str = X.toLowerCase();
		String temp = "";
		String answer = "";

		// ChackPoint1. 문자 뒤집기
		for(int i=X.length()-1; i>=0; i-- ) {
			temp += String.valueOf(arr[i]);
		}

		// CheckPoint2. 회문 비교하기
		if(str.equals(temp) == true) { answer = "YES"; }
		else { answer = "NO"; }

		return answer;
	}
}

// 강의내용1
import java.util.*;

class Main {    
    public String solution(String s){
        String answer="NO";
        s=s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp=new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
