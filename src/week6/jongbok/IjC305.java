import java.util.*;

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int cnt = 0; 
      
      for(int i=1; i<=(N/2); i++){
          
          int tmp = 0; 
          
          for(int j=i; j<=N; j++){
              tmp += j;
              if(tmp == N){
                  cnt++;
              }else if(tmp > N){
                  break;
              }
          }
      }      
      
      System.out.println(cnt);
      
      
    }
}
