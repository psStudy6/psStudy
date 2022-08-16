import java.util.*;

public class Main {
    
  
    public void insertionSort(int[] arr, int N){
        
        
        for(int i=0; i<N; i++){
            
            int num = arr[i];
            int j;
            
            for(j=i-1; j>=0; j--){
                if(num <= arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;                
                }
            }
            
            arr[j+1] = num;
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
      
      T.insertionSort(arr, N);
      
      for(int i=0; i<N; i++){
          System.out.println(arr[i]);
      }
      
      
      
    }
}
