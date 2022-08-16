import java.util.*;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int T = sc.nextInt();
      ArrayList<String> arr = new ArrayList<>();
      
      for(int i=1; i<=T; i++){
          String str = sc.next();
          Stack<Character> stk = new Stack<>();
          boolean isValid = true;
          
          for(int j=0; j<str.length(); j++){
              char c = str.charAt(j);
              
              if(c == '('){
                  stk.push(c);
              }else{
                  if(stk.size() == 0){
                      isValid = false;
                      break;
                  }else{
                      stk.pop();
                  }
              }
          }
          if(isValid == false || stk.size() != 0){
              arr.add("NO");
          }else{
              arr.add("YES");
          }
          
      }
      
      for(String str: arr){
          System.out.println(str);
      }
      
    }
}
