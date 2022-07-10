package ju;
//11656번 접미사 배열 by soram
import java.io.IOException;
import java.util.*;

class Main {  
public void solution(String str){
  int index = str.length();
  String[] arr=new String[index];
  for(int i=0;i<index;i++) {
	  arr[i]=str.substring(i);
  }
  Arrays.sort(arr);//오름차순 정렬 메소드
  for(String k:arr) {
	  System.out.println(k);
	  
  }
      
    
  

}

public static void main(String args[]) throws IOException{ 
  Main T =new Main();
  Scanner sc = new Scanner(System.in);

  String input=sc.nextLine();
  T.solution(input);
 

  
 sc.close();
  
  
  
}
}
