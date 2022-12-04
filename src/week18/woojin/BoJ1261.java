package week18.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BoJ1261 {

    static int n, m;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[][] check = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Pos implements Comparable<Pos> {
        int x, y;
        int count;

        public Pos(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Pos o) {
            return this.count - o.count;
        }
    }

    static void bfs() {
        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.offer(new Pos(0, 0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            if (pos.x == n - 1 && pos.y == m - 1) {
                answer = Math.min(pos.count, answer);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int dx = pos.x + check[i][0];
                int dy = pos.y + check[i][1];

                if (0<=dx && dx<n && 0<=dy && dy<m && !visited[dx][dy]) {
                    if (map[dx][dy] == 0) {
                        q.offer(new Pos(dx, dy, pos.count));
                    }
                    if (map[dx][dy] == 1) {
                        q.offer(new Pos(dx, dy, pos.count + 1));
                    }
                    visited[dx][dy] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs();
        System.out.println(answer);
    }
}