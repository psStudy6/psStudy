import java.util.*;
  
public class Main {
  public static void main(String[] args){
      
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    
    
    int start = n;
    int cnt = 0; 
    
    while(true){
        
        int a = n / 10;
        int b = n % 10;
        int tmp = a+b;
        
        int c = tmp % 10;
        n = 10*b+c;
        cnt++;
        
        if(n == start){
            break;
        }
    }
    

    System.out.println(cnt); 
    
    
  }
}
