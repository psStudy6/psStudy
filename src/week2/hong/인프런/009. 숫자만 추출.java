/**
 * 문제 제목 : 009. 숫자만 추출
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main M = new Main();
		Scanner in = new Scanner(System.in);
		String X = in.nextLine();
		in.close();
		System.out.println(M.solution(X));
	}

	public String solution(String X) {
		// CheckPoint1. 정규식을 통해서 숫자를 제외한 나머지 문자열들 제거
		String temp = X.replaceAll("[^ 0-9]", "");
		char[] arr = temp.toCharArray();
		String num = "";
		String answer = "";

		for(int i=0; i<arr.length; i++) {
			num += String.valueOf(arr[i]);
		}

		// CheckPoint2. 앞에 몇개의 0이 들어 갈지 모르는 상황을 대비하여 해당 길이만큼 반복문을 돌려준다.
		for(int j=0; j<num.length(); j++) {
			if("0".equals(num.substring(0, 1))) {
				num = num.substring(1,num.length());
			}
		}
		answer = num;

		return answer;
	}
}

// 강의내용1 - 아스키코드 사용
import java.io.*;

public class Main {
    public int solution(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) { //'0'~'9' -> 아스키 코드 48 ~ 57
                answer = answer * 10 + (c - 48);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(T.solution(str));
    }
}

// 강의 내용2 - Character.isDigit()
import java.io.*;

public class Main {
    public int solution(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
         
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
