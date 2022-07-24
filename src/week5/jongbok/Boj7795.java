import java.util.*;
  
public class Main {
  public static void main(String[] args){
      
    Scanner sc =new Scanner(System.in);
    int T = sc.nextInt();

    for(int i=0; i<T; i++){
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int[] arr1 = new int[A];
        int[] arr2 = new int[B];
        
        for(int j=0; j<A; j++){
            int num = sc.nextInt();
            arr1[j] = num;
        }
        
        for(int j=0; j<B; j++){
            int num = sc.nextInt();
            arr2[j] = num;
        }
        
        Arrays.sort(arr1, 0, A);
        Arrays.sort(arr2, 0, B);
      
        
        int pos1 = 0;
        int pos2 = 0; 
        int answer = 0; 
        
        while(true){
            
            if(pos1 == A){
                break;
            }
            
            if(pos2 == B){
                pos1++;
                answer += pos2;
                continue;
            }
            
            if(arr1[pos1] <= arr2[pos2]){
                pos1++;
                answer += pos2;
            }else{
                if(pos2 < B){
                  pos2++;
                }
                
            }
        }
        
        System.out.println(answer);
        
        
    }
    
    
    
  }
}
