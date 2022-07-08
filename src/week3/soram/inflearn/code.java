package ju;
//코테자바.12 암호
import java.util.*;
class Main {  
  public static String solution(int n,String s){
    String answer = "";
    for(int i=0;i<n;i++){
      String tmp = s.substring(0,7).replace('#','1').replace('*','0');
      //알파벳 한문자는 7개의 0과 1로 구성
      int num = Integer.parseInt(tmp,2);
      //parseInt(String s,int radix);
      //ex.1000011(2)->67
      //radix에는 해당 진법을 넣는다
      answer+=(char)num;
      s=s.substring(7);//방금전 구한 7개의 문자를 제거하는 과정
    }
    return answer;
  }
  public static void main(String args[]) { 
   Main T =new Main();
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    String str = sc.next();
    System.out.println(T.solution(n,str));
  } 
}
