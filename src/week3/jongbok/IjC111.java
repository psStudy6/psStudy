import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String str = sc.next();
    
    int len = str.length();
    String answer = "";
    
    StringBuilder sb = new StringBuilder();
    sb.append(str.charAt(0));
    int cnt = 1; 
    
    for(int i=1 ;i<len; i++){
       if(str.charAt(i-1) == str.charAt(i)){
           cnt++;
       }else{
           if(cnt != 1){
               String tmp = Integer.toString(cnt);
               sb.append(tmp);
               cnt = 1;
           }
           
           sb.append(str.charAt(i));
       }
          
    }
    
    if(cnt != 1){
        sb.append(Integer.toString(cnt));
    }
    
    answer = sb.toString(); 
    
    System.out.println(answer);
    
    return ;
  }
}
