import java.util.*;

public class Main {
    
    
    public int[] bubbleSort(int N, int[] arr){
        
        for(int i=0; i<N-1; i++){
            
            for(int j=0; j<N-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            
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
      
      int[] result = T.bubbleSort(N, arr);
     
      for(int i=0; i<N; i++){
          System.out.print(arr[i]+ " ");
      }
        
    }
}
