import java.util.*;

public class Main {
    
    public static void main(String args[]) {
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      
      int[][] points = new int[N][2];
      
      for(int i=0; i<N; i++){
          int x = sc.nextInt();
          int y = sc.nextInt();
          points[i][0] = x;
          points[i][1] = y;
      }
      
      Arrays.sort(points, (a,b) -> {
          if(a[0] == b[0]){
              return a[1]-b[1];
          }else{
              return a[0]-b[0];
          }
      });
      
      
      
      for(int i=0; i<N; i++){
          System.out.println(points[i][0] + " " + points[i][1]);
      }
      
      
      
    }
}
