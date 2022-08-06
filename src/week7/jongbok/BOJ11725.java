import java.util.*;

public class Main {
    
    
    public static boolean[] check;
    public static int[] parent;
    public static ArrayList<Integer>[] list;
    
    
    public void dfs(int num){
        if(check[num]){
            return;
        }
        check[num] = true;
        
        for(Integer val: list[num]){
            if(check[val] == false){
                parent[val] = num;
                dfs(val);
            }
        }
    }
    
    
    public static void main(String args[]) {
        
      Main T = new Main();    
        
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      list = new ArrayList[n+1];
      check = new boolean[n+1];
      parent = new int[n+1];
      
      for(int i=1; i<=n; i++){
          list[i] = new ArrayList<>();
      }
      
      for(int i=1; i<=n-1; i++){
          int a = sc.nextInt();
          int b = sc.nextInt();
          list[a].add(b);
          list[b].add(a);
      }
      
      
      for(int i=1; i<=n ;i++){
          if(check[i] == false){
              T.dfs(i);
          }
      }
      
      for(int i=2; i<=n; i++){
          System.out.println(parent[i]);
      }
      
      

    }
}
