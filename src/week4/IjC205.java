import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    int answer = 0; 
    
    int[] arr = new int[n+1];
    
    for(int i=2; i<=n; i++){
      
         if(arr[i] == 0){
           answer++;
           
           for(int j=i; j<=n; j+=i){
               if(arr[j] == 0){
                  arr[j] = 1; 
               } 
           }
         }
    }
    
    System.out.println(answer); 
    
    
  }
}
