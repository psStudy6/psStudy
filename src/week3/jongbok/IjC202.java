import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    
    for(int i=0; i<n; i++){
      int height = sc.nextInt(); 
      arr.add(height);
    }
    
    int maxHeight = arr.get(0);
    int cnt = 1;
    
    for(int i=1; i<n; i++){
      if(maxHeight < arr.get(i)){
         maxHeight = arr.get(i);
         cnt++;
      }
    }
    
    System.out.println(cnt); 
 	
    return ;
  }
}
