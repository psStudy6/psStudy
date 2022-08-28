import java.util.*;

public class Main {
    
    public int[] selectionSort(int N, int[] arr){
        
        for(int i=0; i<N; i++){
            
            int minPos = i;
            
            
            for(int j=i+1; j<N; j++){
                if(arr[j] < arr[minPos]){
                    minPos = j;
                }
            }
            
            int tmp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = tmp;
        }
        
        return arr; 
        
    }
    
    
    public static void main(String args[]) {
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[] arr = new int[110];
      
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      int[] result = T.selectionSort(N, arr);
      
      
      for(int i=0; i<N; i++){
          System.out.print(arr[i]+ " ");
      }
      
    }
}
