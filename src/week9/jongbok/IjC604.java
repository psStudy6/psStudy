import java.util.*;

public class Main {
    
    public static void main(String args[]) {
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt(); 
      HashSet<Integer> set = new HashSet<>();
      
      
      for(int i=0; i<N; i++){
        int num = sc.nextInt();
        if(set.contains(num)){
            System.out.println("D");
            return;
        }else{
            set.add(num);
        }
      }
      
      System.out.println("U");
      
    }
}
