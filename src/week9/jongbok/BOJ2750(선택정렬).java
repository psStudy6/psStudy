import java.util.*;

public class Main {
    
    
    public void selectionSort(int[] arr, int N){
        
        
        for(int i=0; i<N; i++){
            
            int num = arr[i];
            int minIndex = i;
            
            for(int j=i+1; j<N; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            
        }
        
    }
    
    
    public static void main(String args[]) {
      
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      
      int[] arr = new int[1010];
      
      int N = sc.nextInt();
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      T.selectionSort(arr, N);
      
      for(int i=0; i<N; i++){
          System.out.println(arr[i]);
      }
      
      
      
    }
}
