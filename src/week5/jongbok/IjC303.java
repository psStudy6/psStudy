import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] arr = new int[100010];
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    int maxSum = Integer.MIN_VALUE;
    int sum = 0; 
    
    for(int i=0; i<n; i++){
        int num = sc.nextInt();
        arr[i] = num;
    }
    
    for(int i=0; i<k; i++){
        sum += arr[i];
    }
    
    maxSum = Math.max(maxSum, sum);
    
    
    for(int i=k; i<n; i++){
        sum += arr[i];
        sum -= arr[i-k];
        maxSum = Math.max(maxSum, sum);
    }
    
    System.out.println(maxSum);

    
    return ;
  }
}
