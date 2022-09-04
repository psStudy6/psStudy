package week11.ram;
import java.util.*;
import java.io.*;



public class BoJ25416 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    //위 아래 왼 오

    static final int size=5;
    static int[][] board = new int[size][size];
    static int[][] dis = new int[size][size];
    static int answer = 0;
    static boolean goal=false; //출구를 찾았는지 확인하는 변수
    static class Point{

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
       }

    }
    public static void BFS(int x, int y){

        Queue<Point> qu = new LinkedList<>();

        qu.offer(new Point(x, y));

        while(!qu.isEmpty()){

                Point point = qu.poll();

                x = point.x;
                y = point.y;
                board[x][y] = -1;

                for (int i = 0; i < 4; i++) {

                    int tmpX = x + dx[i];
                    int tmpY = y + dy[i];
                    if(tmpX >= 0 && tmpX <=size-1 && tmpY >= 0 && tmpY <= size-1 && board[tmpX][tmpY] == 0){
                            dis[tmpX][tmpY] = dis[x][y] + 1;
                            board[tmpX][tmpY]=-1;
                           qu.offer(new Point(tmpX, tmpY));
                    }
                    
                    if(tmpX >= 0 && tmpX <=size-1 && tmpY >= 0 && tmpY <= size-1 && board[tmpX][tmpY] == 1) {
                       qu.clear();
                       goal = true;
                       answer = dis[x][y]+1;
                       return;
                       
                    }

                }
                
        
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      for(int i=0;i<size;i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0;j<size;j++) {
            board[i][j]=Integer.parseInt(st.nextToken());
            
         }

      }
         
      st=new StringTokenizer(br.readLine());
      int aaa = Integer.parseInt(st.nextToken());
      int bbb = Integer.parseInt(st.nextToken());
      br.close();
        BFS(aaa, bbb);

        if(goal==false)
            answer = -1;
        
        System.out.println(answer);

    }
}
