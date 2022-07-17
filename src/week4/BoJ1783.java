import java.util.*;


// 다음 블로그를 참고했습니다.
// https://songwonseok.github.io/algorithm/BOJ-1783/

public class Main {
    
    public static void main(String args[]) {
      Main T = new Main();
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int result = 0; 
      
      // N이 1이면 이동이 불가능함
      if(N == 1){
          result = 1;
      }
      // N이 2일 때는, 2, 3번만 적용할 수 있음
      // 4가지 케이스를 모두 사용할 수 없으므로, 최대값은 4
      else if(N == 2){
          result = Math.min((M+1)/2, 4);
      }
      // M>=7일 때 4가지 케이스 모두 적용 가능 
      // M>=7일 때 4가지 케이스 모두 적용 후, 1, 4번을 반복함
      // M이 7보다 작을 때는, 최대 값이 4
      else if(N >= 3){
          
          if(M < 7){
              result = Math.min(M, 4);
          }else{
              result = M-2;
          }
          
      }
      
      System.out.println(result);      
      
    }
}
