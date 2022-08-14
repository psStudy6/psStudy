import java.util.*;



public class Main {
    
    public static int[][] map;
    public static boolean[][] check;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static int cnt;
    
    
    public boolean isInside(int x, int y){
        if(0<=x && x<N && 0<=y && y<N){
            return true;
        }else{
            return false;
        }
    }
    
    
    public void dfs(int x, int y){
        
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(isInside(nx, ny) && check[nx][ny] == false  && map[nx][ny] == 1){
                check[nx][ny] = true;
                cnt++; 
                dfs(nx, ny);
            }
        }
        
        
    }
    
    
    
    public static void main(String args[]) {
        
      Main T = new Main();    
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      map = new int[N][N];
      check = new boolean[N][N];
      cnt = 0; 
      int area = 0; 
      List<Integer> answer = new ArrayList<>();
      
      for(int i=0; i<N; i++){
          
          String str = sc.next();
          
          for(int j=0; j<N; j++){
              int num = str.charAt(j)-'0';
              map[i][j] = num;
          }
      }
      
      for(int i=0; i<N; i++){
          for(int j=0; j<N; j++){
              if(map[i][j] == 1 && check[i][j] == false){
                  int before = cnt;
                  area++;
                  check[i][j] = true;
                  cnt++;
                  T.dfs(i, j);
                  answer.add(cnt-before);
              }
          }
      }
      
      Collections.sort(answer);
      
      System.out.println(area);
      for(Integer num: answer){
          System.out.println(num);
      }
      



    }
}
