import java.util.*;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      Stack<Character> stk = new Stack<>();
      
      String str = sc.next();
      boolean isRight = true;
      
      for(int i=0; i<str.length(); i++){
          char c = str.charAt(i);
          
          if(c == '('){
              stk.push(c);
          }else{
              if(stk.size() == 0){
                  isRight = false;
                  break;
              }else{
                  stk.pop();
              }
          }
          
      }
      
      if(stk.size() != 0){
        isRight = false;   
      }
      
      if(isRight){
          System.out.println("YES");
      }else{
          System.out.println("NO");
      }
      
    }
}
