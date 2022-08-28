import java.util.*;

public class Main {
    
    public void recursive(int N){
        
        if(N == 0){
            return;
        }
        
        recursive(N/2);
        System.out.print(N%2);
    }
    
    public static void main(String args[]) {
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      T.recursive(N);
    }
}
