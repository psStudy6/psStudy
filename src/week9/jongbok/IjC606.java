import java.util.*;

public class Main {
    
    public static void main(String args[]) {
      Main T = new Main();
      ArrayList<Integer> answer = new ArrayList<>();
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt(); 
      int[] arr = new int[110];
      int[] tmp = new int[110];
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
          tmp[i] = num;
      }
      
      Arrays.sort(tmp, 0, N);
      
      for(int i=0; i<N; i++){
          if(arr[i] != tmp[i]){
              answer.add(i+1);
          }
      }
     
      for(int i=0; i<2; i++){
          System.out.print(answer.get(i) + " ");
      }
      
    }
}
