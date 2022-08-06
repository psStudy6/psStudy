import java.util.*;



public class Main {
    
    public static int[][] tree;
    public static StringBuilder sb;

    
    
    public void preOrder(int root){
        
        sb.append((char)(root+'A'));
        if(tree[root][0] > 0) preOrder(tree[root][0]);
        if(tree[root][1] > 0) preOrder(tree[root][1]);
    }
    
    
    public void inOrder(int root){
        
        if(tree[root][0] > 0) inOrder(tree[root][0]);
        sb.append((char)(root+'A'));
        if(tree[root][1] > 0) inOrder(tree[root][1]);
    }
    
       
    public void postOrder(int root){
        
        if(tree[root][0] > 0) postOrder(tree[root][0]);
        if(tree[root][1] > 0) postOrder(tree[root][1]);
        sb.append((char)(root+'A'));
    }
    
    
    
    
    public static void main(String args[]) {
        
      Main T = new Main();    
      sb = new StringBuilder();
        
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      tree = new int[N][2];
      
      
      for(int i=1; i<=N; i++){
          int root = sc.next().charAt(0)-'A';
          int left = sc.next().charAt(0)-'A';
          int right = sc.next().charAt(0) - 'A';
          
          
          tree[root][0] = left;
          tree[root][1] = right;
      }
      
      T.preOrder(0);
      sb.append('\n');
      T.inOrder(0);
      sb.append('\n');
      T.postOrder(0);
      

      System.out.println(sb);        



    }
}
