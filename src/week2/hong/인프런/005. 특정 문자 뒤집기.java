/**
 * 문제 제목 : 005. 특정 문자 뒤집기
 * 강의 시청 : ✔️
 */
 

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class StringReverse {

	public String solution(String X) {

		char[] arr = X.toCharArray();
		int len = 0 , lastLen = X.length() -1;
		char tmp;
		String answer = "";

		// CheckPoint1. 문자와 특수문자를 체크하기
		while(len < lastLen) {
			if(!Character.isAlphabetic(arr[len])) {
				len++;
			}

			else if(!Character.isAlphabetic(arr[lastLen])) {
				lastLen--;
			}

			else {

				// Checkpoint2. 데이터 입력
				tmp = arr[len];
				arr[len] = arr[lastLen];
				arr[lastLen] = tmp;

				// Checkpoint3. 다음(indexOf or lastIndexOf) 문자열 증감연사자로 다음 문자열을 체크하기
				len++;
				lastLen--;

			}
		}

		answer = String.valueOf(arr);
		return answer;
	}

	public static void main(String[] args) {
		StringReverse M = new StringReverse();
		Scanner in = new Scanner(System.in);

		String X = in.next();
		in.close();

		System.out.println(M.solution(X));
	}
}

// 강의 방법 1
public class Main{
    public String solution(String str) {
      String answer;
      char[] s = str.toCharArray();
      int it = 0, rrt = str.length()-1;
      
      while(it < rt) {
        if(!Character.isAlphabetic(s[it])) it++;
        else if(!Character.isAlphabetic(s[rt])) rt++;
        else {
          char temp =s[it];
          s[it] = s[rt];
          s[rt] = tmp;
          it++;
          rt--;
        }  
      }
      answer = String.valueOf(s);
      return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
    }
}
