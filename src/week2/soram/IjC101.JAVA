import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Main T = new Main();
    Scanner in=new Scanner(System.in);
    String input_string = in.next();
    String input_char = in.next();
    
    System.out.println(T.solution(input_string,input_char));
    
  }
  static int solution(String str,String chch){
    int ans=0;
    str=str.toLowerCase();
    chch=chch.toLowerCase();
    char ch = chch.charAt(0);
    for(int i=0;i<str.length();i++){
      if(str.charAt(i)==ch) ans++;
      
      
    }return ans;
    
  }
}
