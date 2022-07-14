import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    
    int n = sc.nextInt();
    int[] arr = new int[50];
    arr[0] = 1;
    arr[1] = 1;
    
    for(int i=2; i<45; i++){
      arr[i] = arr[i-1] + arr[i-2];
    }
    
    for(int i=0; i<n; i++){
       System.out.print(arr[i]+ " "); 
    }
    
    return ;
  }
}
