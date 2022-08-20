package week4.jongbok;
import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n+1][n+1];
    
    int maxSum = Integer.MIN_VALUE;
    int tmpSum1 = 0;
    int tmpSum2 = 0; 
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            int num = sc.nextInt();
            arr[i][j] = num;
        }
    }
    
    for(int i=0; i<n; i++){
        tmpSum1 = 0;
        tmpSum2 = 0; 
        for(int j=0; j<n; j++){
            tmpSum1 += arr[i][j];
            tmpSum2 += arr[j][i];
        }
        
        maxSum = Math.max(maxSum, tmpSum1);
        maxSum = Math.max(maxSum, tmpSum2);
    }
    
    tmpSum1 = 0;
    tmpSum2 = 0; 
    
    for(int i=0; i<n; i++){
        tmpSum1 += arr[i][i];
        tmpSum2 += arr[(n-1)-i][i];
    }
 
    maxSum = Math.max(maxSum, tmpSum1);
    maxSum = Math.max(maxSum, tmpSum2);
      
    System.out.println(maxSum);
    return ;
  }
}
