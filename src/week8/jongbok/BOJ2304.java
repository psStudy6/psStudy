import java.util.*;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int[] arr = new int[1010];
      int minIndex = Integer.MAX_VALUE;
      int maxIndex = Integer.MIN_VALUE;
      int maxHeight = Integer.MIN_VALUE;
      int maxHeightIndex = Integer.MAX_VALUE;
      int area = 0; 
      
      for(int i=1; i<=N; i++){
          int L = sc.nextInt();
          int H = sc.nextInt();
          arr[L] = H;
          minIndex = Math.min(minIndex, L);
          maxIndex = Math.max(maxIndex, L);
          if(maxHeight < H){
              maxHeight = H;
              maxHeightIndex = L;
          }
      }
      
      int currHeight = 0; 
      
      
      for(int i=minIndex; i<=maxHeightIndex; i++){
          
          if(arr[i] != 0){
              if(currHeight < arr[i]){
                  currHeight = arr[i];
              }
          }
          
          area += currHeight;
      }
      
      currHeight = 0; 
      
      for(int i=maxIndex; i>=maxHeightIndex; i--){
          
          if(arr[i] != 0){
              if(currHeight < arr[i]){
                  currHeight = arr[i];
              }
          }
          area += currHeight;
      }
      
      
      area -= arr[maxHeightIndex];
      
      
      
      
      System.out.println(area);
      
    }
}
