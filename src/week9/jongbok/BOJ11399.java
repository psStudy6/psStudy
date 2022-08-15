import java.util.*;

public class Main{
    
    
       
    
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int answer = 0; 
      
      int[] arr = new int[1010];
      
      int N = sc.nextInt();
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      
      Arrays.sort(arr);
      
      int time = 0;
      int accumulate = 0; 
      answer += arr[0];
      
      for(int i=1; i<arr.length; i++){
          accumulate += arr[i-1];
          answer += accumulate;
          answer += arr[i];
      }
      
      System.out.println(answer);
      
      
    }
    
    
    
    
}
