import java.util.*;


public class Main {
    
    
    public int binarySearch(int target, int[] arr){
        
        int answer = 0; 
        
        int N = arr.length;
        
        int start = 0;
        int end = N-1;
        
        while(start <= end){
            
            int mid = (start+end)/2;
            
            if(target == arr[mid]){
                answer = mid+1;
                break; 
            }else if(target < arr[mid]){
                end = mid-1;
            }else if(target > arr[mid]){
                start = mid+1; 
            }
            
        }
        
        return answer; 
        
        
    }
    
   
    public static void main(String args[]) {
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] arr = new int[N];
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      
      Arrays.sort(arr);
      
      
      int answer = T.binarySearch(M, arr);
     
      System.out.println(answer);
      
    }
}
