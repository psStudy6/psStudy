package week18.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BoJ2178 {
    static int[][] map;
    static boolean[][] visit;
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n, m;
    static Queue<Integer> qx = new LinkedList<Integer>();
    static Queue<Integer> qy = new LinkedList<Integer>();

    static void bfs(int x, int y){
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];

                if(0<=dx && 0<=dy && dx<n && dy<m) {
                    if(!visit[dx][dy] && map[dx][dy] ==1){
                        qx.add(dx);
                        qy.add(dy);
                        visit[dx][dy] = true;
                        map[dx][dy] = map[x][y]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(Input[j]);
            }
        }
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }
}
