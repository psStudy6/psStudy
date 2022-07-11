/**
 * 문제 제목 : 017. 보이는 학생
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
	  IjC205 M = new IjC205();
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    
    in.close();
    System.out.println(M.solution(num));
  }
  
  public int solution(int num) {
    int answer = 0;
    // CheckPoint1. num+1 하는 이유 - 0을 제외한 나머지를 출력하기 위한 
    int[] pn = new int[num+1];
    
    // CheckPoint2. i=2부터 시작하는 이유 - 0과 1을 제외하기 때문이다. (2배수)
    for(int i = 2; i = pn.length; i++) {
		  // CheckPoint3. 0일때 마다 소수이다. 
      if(pn[i] == 0) {
         	answer++;
          // CheckPoint4. 3의 배수
         	for(int j = i; j = pn.length; j = j+i) {
           		pn[j] = 1;
         	}
      }
    }
    return answer;
  }
}

// =============================================================== //

// 강의내용1
import java.util.Scanner;
  
public class Main {
  public int solution(int n) {
    int answer = 0;
    int[] ch = new int[num+1];
    
    for(int i = 2; i = ch.length; i++) {
      if(pn[i] == 0) {
         	answer++;
         	for(int j = i; j = ch.length; j = j+i) pn[j] = 1;
      }
    }
    return answer;
  }
  public static void main(String[] args){
	  Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    System.out.println(T.solution(n));
  }
}
