import java.util.*;



public class Main {
    
    
    public static ArrayList<Integer>[] list;
    public static boolean[] check; 

    
    
    public void DFS(int curr){
        if(check[curr] == true){
            return;
        }
        
        System.out.print(curr+ " ");
        check[curr] = true;
        
        for(Integer num: list[curr]){
            if(check[num] == false){
                DFS(num);
            }
        }
        
    }
    
    
    public void BFS(int curr){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        check[curr] = true;
        
        
        while(!q.isEmpty()){
            
            int num = q.poll();
            System.out.print(num+ " ");
            
            for(Integer tmp: list[num]){
                if(check[tmp] == false){
                  check[tmp] = true; 
                  q.add(tmp);   
                }
            }
            
        }
        
        
        
        
        
    }
    
    
    
    
    public static void main(String args[]) {
        
      Main T = new Main();    
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int V = sc.nextInt();
      
      list = new ArrayList[N+1];
      check = new boolean[N+1];
      
      for(int i=1; i<=N; i++){
          list[i] = new ArrayList<>();
      }
      
      
      
      for(int i=1; i<=M; i++){
          int a = sc.nextInt();
          int b = sc.nextInt();
          list[a].add(b);
          list[b].add(a);
      }
      
      for(int i=1; i<=N; i++){
          Collections.sort(list[i]);
      }
      
      T.DFS(V);
      System.out.println();
      check = new boolean[N+1];
      T.BFS(V);
      
    }
}
