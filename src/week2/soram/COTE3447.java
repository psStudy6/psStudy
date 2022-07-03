//백준 3447번 버그왕 by soram
//틀렸습니다. 코드수정필요
import java.io.IOException;
import java.util.*;

class BUG {  
public String solution(String s){
  s=s.replace("BUG","");
  return s;
      
    
  

}

public static void main(String args[]) throws IOException{ 
  Main T =new Main();
  Scanner sc = new Scanner(System.in);
  while(sc.hasNextLine()){
    String input=sc.nextLine();
    System.out.println(T.solution(input));
  }
  

  
 sc.close();
  
  
  
}
}
