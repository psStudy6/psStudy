/**
 * 문제 제목 : 016. 피보나치 수열
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
 	Main M = new Main();
    Scanner in = new Scanner(System.in);
    
    int num = in.nextInt();
    in.close();
    System.out.println(M.solution(num));
  }
  
  public String solution(int num) {
    String answer = "";
    int[] pivo = new int[num];
    pivo[0] = 1;
    pivo[1] = 1;
    
    for(int i=2; i<pivo.length; i++) {
      pivo[i] = pivo[i-1] + pivo[i-2];
    }
    
    for(int x : pivo) {
      answer += x + " ";
    }
    return answer;
  }
}

// =============================================================== //

// 강의내용1
public class Main {    
    public void solution(int n){
        int a=1, b=1, c;
        System.out.print(a+" "+b+" ");
        for(int i=2; i<n; i++){
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        T.solution(n);
    }
}
