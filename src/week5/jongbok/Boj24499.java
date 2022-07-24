import java.util.*;
  
public class Main {
  public static void main(String[] args){
      
    Scanner sc =new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] arr = new int[100010];
    
    
    for(int i=0; i<N; i++){
        int num = sc.nextInt();
        arr[i] = num;
    }
    
    
    int sum = 0; 
    int maxSum = Integer.MIN_VALUE;
    
    for(int i=0; i<K; i++){
        sum += arr[i];
    }
    
    maxSum = Math.max(maxSum, sum);
    
    int start = 0;
    int end = K-1;
    
    while(true){
        
        end++;
        end %= N;
        sum += arr[end];
        sum -= arr[start];
        start++;
        start %= N;
        
        maxSum = Math.max(maxSum, sum);
        
        if(start == 0 && end == K-1){
            break;
        }
        
        
    }
    
    System.out.println(maxSum);
    
    
    
    
  }
}
