package week18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 2178 미로 탐색
 * 
 * 핵심 : BFS 탐색 이용 -단계별 탐색
 * -> 이동 가능 경로에 가중치를 줌
 */
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BoJ2178 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[][] arr) {
        int[][] dist = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        // 시작점 세팅
        q.add(new Pair(0, 0));
        check[0][0] = true;
        dist[0][0] = 1;

        // 탐색
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            
            // 4방향
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 > nx || nx >= n || 0 > ny || ny >= m) {
                    continue;
                }
                // 방문하지 않았고 이동할 수 있는 칸
                if (check[nx][ny] == false && arr[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1; // 가중치
                    check[nx][ny] = true;
                }
            }
        }
        return dist[n -1][m -1];
    }
}
