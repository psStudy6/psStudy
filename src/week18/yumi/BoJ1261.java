package week18.yumi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BoJ1261 {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 가로
        int n = sc.nextInt(); // 세로
        sc.nextLine();
        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        solution(m, n, arr);
    }

    private static void solution(int m, int n, int[][] arr) {
        int[][] dist = new int [n][m];
        Queue<Position> queue = new LinkedList<Position>();
        Queue<Position> next_queue = new LinkedList<Position>();

        queue.offer(new Position(0, 0));
        Arrays.fill(dist, -1);
        dist[0][0] = 0;
        
        // 탐색
        while (!queue.isEmpty()) {
            Position p = queue.remove();
            int x = p.x;
            int y = p.y;

            // 4방향
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 > nx || nx >= n || 0 > ny || ny >= m) {
                    continue;
                }
                // 이미 탐색한 경우
                if (dist[nx][ny] != -1) {
                    continue;
                }
                // 빈방
                if (arr[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y];
                    queue.offer(new Position(nx, ny));
                    continue;
                }
                // 벽
                dist[nx][ny] = dist[x][y]+1;
                next_queue.offer(new Position(nx, ny));
            }
            
            if (queue.isEmpty()) {
                queue = next_queue;
                next_queue = new LinkedList<Position>();
            }
        }
        System.out.println(dist[n -1][m -1]);
    }
}
