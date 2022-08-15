import java.util.*;

public class Main {
    

    public void bubbleSort(int[] arr, int N){        
        
        for(int i=0; i<N; i++){
            
            for(int j=0; j<N-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
            
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
      
      T.bubbleSort(arr, N);
      
      
      for(int i=0; i<N; i++){
          System.out.println(arr[i]);
      }
      
      
      
    }
}
