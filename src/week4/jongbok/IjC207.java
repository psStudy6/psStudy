package week4.jongbok;
import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] arr = new int[110];
    int n = sc.nextInt(); 
    int answer = 0; 
    
    for(int i=0; i<n; i++){
      int num = sc.nextInt();
      arr[i] = num;
    }
    
    int cnt = 0;
    
    for(int i=0; i<n; i++){
        if(arr[i] == 1){
            answer += 1;
            answer += cnt;
            cnt++; 
        }else{
            cnt = 0; 
        }
    }
    
    System.out.println(answer); 
    
  }
}
