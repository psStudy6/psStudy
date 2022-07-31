import java.util.*;

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int K = sc.nextInt();
      int[] arr = new int[100010];
      int maxLen = 0; 
      HashMap<Integer, Integer> map = new HashMap<>();
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      for(int i=0; i<K; i++){
          
          int num = arr[i];
          
          if(map.containsKey(num)){
              map.put(num, map.get(num)+1);
          }else{
              map.put(num, 1);
          }
      }
      
      
      System.out.print(map.size() + " ");
      
      
      for(int i=K; i<N; i++){
          
          int num = arr[i];
          int delNum = arr[i-K];
          
           
          if(map.containsKey(num)){
              map.put(num, map.get(num)+1);
          }else{
              map.put(num, 1);
          }
          
          if(map.get(delNum) == 1){
              map.remove(delNum);
          }else{
              map.put(delNum, map.get(delNum)-1);
          }
          
          System.out.print(map.size() + " ");
      }
      
      
      
      
    }
}
