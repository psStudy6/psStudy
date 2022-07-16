import java.util.*;

public class Main {
    
    public static void main(String args[]) {
      Main T = new Main();
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int result = 0; 
      
      if(N == 1){
          result = 1;
      }else if(N == 2){
          result = Math.min((M+1)/2, 4);
      }else if(N >= 3){
          
          if(M < 7){
              result = Math.min(M, 4);
          }else{
              result = M-2;
          }
          
      }
      
      System.out.println(result);      
      
    }
}
