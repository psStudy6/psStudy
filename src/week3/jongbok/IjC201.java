import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    
    for(int i=0; i<n; i++){
       int num = sc.nextInt();
       arr.add(num);
    }
    
    System.out.print(arr.get(0)+ " ");
    
    for(int i=1; i<n; i++){
       if(arr.get(i-1) < arr.get(i)){
           System.out.print(arr.get(i)+ " "); 
       }
    }
    
    return ;
  }
}
