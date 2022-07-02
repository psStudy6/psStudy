/**
 * 문제 제목 : 007. 회문 문자열
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

// 강의내용1 - for
import java.util.*;
class Main {    
    public String solution(String str){
        String answer="YES";
        str=str.toUpperCase();
        int len=str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}

// ================================================================== //
// 강의내용2 - StringBuilder.reverse
import java.util.*;
class Main {    
    public String solution(String str){
        String answer="NO";
        String tmp=new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}
