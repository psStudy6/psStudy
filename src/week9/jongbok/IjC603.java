import java.util.*;

public class Main {
   
    public static void main(String args[]) {
      Main T = new Main();
      
      Scanner sc = new Scanner(System.in);
      ArrayList<Integer> arr = new ArrayList<>(); 
      int S = sc.nextInt();
      int N = sc.nextInt();
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          
          if(arr.contains(num)){
              int pos = arr.indexOf(num);
              arr.remove(pos);
              arr.add(0, num);
          }else{
              if(arr.size() < S){
                  arr.add(0, num);
              }else{
                  arr.add(0, num);
                  arr.remove(arr.size()-1);
              }
          }
      }
      
      for(int i=0; i<arr.size(); i++){
          System.out.print(arr.get(i)+ " ");
      }
      
      
      
      
    }
}
