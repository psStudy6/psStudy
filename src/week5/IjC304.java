import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int answer = 0; 
    int[] arr = new int[100010];
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    for(int i=0; i<N; i++){
        int num = sc.nextInt();
        arr[i] = num;
    }
    
    int start = 0;
    int end = 0; 
    int sum = arr[end];
    
    while(true){
        
        if(sum < M){
            end++;
            if(end == N){
                break;
            }else{
                sum += arr[end];
            }
        }else if(sum > M){
            sum -= arr[start];
            start++;
        }else if(sum == M){
            answer++;
            sum -= arr[start];
            start++;
        }
    }
    
    System.out.println(answer);

    
    return ;
  }
}
