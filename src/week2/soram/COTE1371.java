package ju;

//1371번 가장 많은 글자 by soram
import java.io.IOException;
import java.util.Scanner;

class Main {  
  public static void main(String args[]) throws IOException{ 
    Scanner sc = new Scanner(System.in);
    //char[] s = new char[2500]; 
    int[] alpha = new int[26];//알파벳을 담을 배열
    int index,max=0;
    String str;
 
    

    while(sc.hasNextLine()){
      str = sc.nextLine();
      for(int i=0;i<str.length();i++){
        if(!(str.charAt(i)==' ')){
          index = str.charAt(i)-'a';//a의 ascii code는 97
        alpha[index]++;    
        }
        
      }
    }
    
    for(int j=0;j<alpha.length;j++){
        if(alpha[j]>alpha[max])
        	max=j;
        
        }
    int key=alpha[max];
    for(int k=0;k<alpha.length;k++) {
    	if(alpha[k]==key)
    		System.out.print((char)(k+'a'));
    	
    }
    
    sc.close();
    
    
    
  }
}
