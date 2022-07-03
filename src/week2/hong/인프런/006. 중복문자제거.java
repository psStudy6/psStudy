/**
 * 문제 제목 : 006. 중복문자제거
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class Solution {
  public static void main(String[] args){
	Solution M = new Solution();
    Scanner in = new Scanner(System.in);
    String str = in.next();
    in.close();
    System.out.println(M.solution(str));
  }

  public String solution(String str) {
	  System.out.println(str);
	  String answer = "";

      for(int i=0; i<str.length(); i++) {
          if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
      }

	return answer;
  }
}

// 강의 방법 1
import java.util.*;

public class Main {
  public String solution(String str) {
	  String answer = "";
      for(int i=0; i<str.length(); i++) {
        // System.out.println(Str.charAt(i)+ " " + i + " " + str.indexOf(str.charAt(i)));
        if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
      }

	return answer;
  }
  public static void main(String[] args){
	  Main M = new Main();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(M.solution(str));
  }

}
