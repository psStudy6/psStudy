import java.util.*;

public class Main {
    
    public static int N;
    public static int maxSum;
    public static int[] T;
    public static int[] P;
    
    public void DFS(int pos, int sum){
        
        if(pos >= N){
            maxSum = Math.max(maxSum, sum);
            return; 
        }
        
        if(pos+T[pos]<=N){
            DFS(pos+T[pos], sum+P[pos]);
        }else{
            DFS(pos+T[pos], sum);
        }
        
        DFS(pos+1, sum);
        
        
        
    }
    
    
    public static void main(String args[]) {
      
      Main K = new Main();
      
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      T = new int[N+1];
      P = new int[N+1];
      
      maxSum = Integer.MIN_VALUE;
      
      for(int i=0; i<N; i++){
          int t = sc.nextInt();
          int p = sc.nextInt();
          T[i] = t;
          P[i] = p;
      }
      
      K.DFS(0, 0);
      
      System.out.println(maxSum);
      
      
      
      
      
      
    }
}
