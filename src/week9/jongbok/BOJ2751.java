import java.util.*;

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr.add(num);
      }
      
      Collections.sort(arr);
      
      
      for(int i=0; i<N; i++){
          sb.append(arr.get(i)).append('\n');
      }
        
      System.out.println(sb);
      
    }
}
