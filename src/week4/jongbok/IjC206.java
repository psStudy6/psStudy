package week4.jongbok;
import java.util.Scanner;
  
public class Main {
     
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    int N = sc.nextInt();
    
    for(int i=1; i<=N; i++){
        
        int num = sc.nextInt();
        
        while(true){
            if(num % 10 == 0){
                num /= 10;
            }else{
                break; 
            }
        }
        
        String str = Integer.toString(num);
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        
        int reversedNum = Integer.parseInt(reversed);
        int cnt = 0; 
        
        for(int j=1; j<=reversedNum; j++){
            if(reversedNum % j == 0){
                cnt++;
            }
        }
        
        if(cnt == 2){
            System.out.print(reversedNum + " ");
        }
    }
    
  }
    
}
