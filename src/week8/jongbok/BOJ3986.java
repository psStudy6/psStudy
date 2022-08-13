import java.util.*;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
     
      int N = sc.nextInt();
      int answer = 0; 
      
      for(int i=1; i<=N; i++){
          
          String str = sc.next();
          Stack<Character> stk = new Stack<>();
      
      
          
          if(str.length() % 2 == 1){
              continue;
          }else{
              
              for(int j=0; j<str.length(); j++){
                  char c = str.charAt(j);
                  
                  if(stk.size() == 0){
                      stk.push(c);
                  }else{
                      if(stk.peek() == c){
                          stk.pop();
                      }else{
                          stk.push(c);
                      }
                  }
              }
              
              if(stk.size() == 0){
                  answer++;
              }
          }
          
      }
      
      System.out.println(answer);
      
      
    }
}
