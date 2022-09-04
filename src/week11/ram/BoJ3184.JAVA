import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BoJ3184 {
     
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static int sheep = 0, wolf = 0;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        R = Integer.parseInt(sc.next());
        C = Integer.parseInt(sc.next());
         
        map = new char[R][C];
        for(int r=0; r<R; r++) {
            String str = sc.next();
            for(int c=0; c<C; c++) {
                map[r][c] = str.charAt(c);
            }
        }
         
        visited = new boolean[R][C];
         
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                // 방문하지 않은 양,늑대, 혹은 단순 필드이면
                if(!visited[r][c] && !(map[r][c] == '#')) BFS(new Vertex(r, c));
            }
        }
        System.out.println(sheep + " " + wolf);
    }
     
    /*
     . : 필드
     # : 울타리
     o : 양
     v : 늑대
     */
    private static void BFS(Vertex vertex) {
        // 해당 영역의 늑대와 양의 수
        int s = 0, w = 0;
        Queue<Vertex> queue = new LinkedList<>();
 
 
        // 양인지 늑대인지 확인하여 마릿수 check
        if(map[vertex.x][vertex.y] == 'o' ) s++;
        else if(map[vertex.x][vertex.y] == 'v' ) w++;
         
        // 방문 표시
        visited[vertex.x][vertex.y] = true;
         
        // 해당 지점을 시작으로 BFS 탐색
        queue.offer(vertex);
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            for(int i=0; i<4; i++) {
                int nX = v.x + dx[i];
                int nY = v.y + dy[i];
                 
                // map 범위 내에서
                if(nX >= 0 && nY >= 0 && nX < R && nY < C) {
                    // 울타리이거나 이미 방문한 곳이면
                    if(visited[nX][nY] || map[nX][nY] == '#') continue;
                     
                    // 양인 경우
                    if(map[nX][nY] == 'o') s++;
                    // 늑대인 경우
                    else if(map[nX][nY] == 'v') w++;
                     
                    // 방문 표시
                    visited[nX][nY] = true;
                    // BFS
                    queue.offer(new Vertex(nX, nY));
                }
            }
        }
 
        // 양과 늑대가 존재하지 않은 경우
        if(s == 0 && w == 0) return;
         
          // 양이 늑대보다 많은 경우
        if(s > w) sheep += s;
        else wolf += w;
    }
 
 
    static class Vertex{
        int x, y;
         
        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
