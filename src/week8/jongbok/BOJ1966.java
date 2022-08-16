import java.util.*;


class Pair{
    
    int pos;
    int importance;
    
    public Pair(int pos, int importance){
        this.pos = pos;
        this.importance = importance;
    }
}


public class Main {
    
    
    
    
    
    public static void main(String args[]) {
      Main TT = new Main();
      Scanner sc = new Scanner(System.in);
      
      int T = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<>(); 
      
      
      for(int i=1; i<=T; i++){
          int N = sc.nextInt();
          int M = sc.nextInt();
          
          Queue<Pair> queue = new LinkedList<>();
          PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
          
          for(int j=1; j<=N; j++){
              
              int importance = sc.nextInt(); 
              
              queue.add(new Pair(j-1, importance));
              pq.add(importance);
          }
          
          int answer = 1; 
          
          while(true){
              
              
              Pair curr = queue.peek();
              
              if(curr.importance == pq.peek()){
                  if(curr.pos == M){
                      arr.add(answer);
                      break; 
                  }else{
                      pq.poll();
                      answer++;
                  }
                  
              }
              
              queue.poll();
              queue.add(curr);
              
          }
          
          
          
          
      }
      
      
      for(Integer num: arr){
          System.out.println(num);
      }
    
      
    }
    
    
    
    
}
