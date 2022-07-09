import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int num = sc.nextInt();
    String str = sc.next();
    ArrayList<String> arr = new ArrayList<>();
    String answer = "";
 
    for(int i=0; i<4; i++){
       String tmp = str.substring(i*7, (i+1)*7);
       arr.add(tmp);   
    } 
    
    for(String tmp: arr){
        int sum = 0; 
        
        String reversed = new StringBuilder(tmp).reverse().toString();
        
        for(int i=0; i<7; i++){
            if(reversed.charAt(i) == '#'){
                sum += Math.pow(2, i);
            }
        }
        
        answer += Character.toString((char)sum);
    }
   
   
    System.out.println(answer); 
    
    
    return ;
  }
}
