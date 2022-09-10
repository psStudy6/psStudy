package week11.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : BOJ 백준 사이트
    title : 양
    number : 3184
    subject : dfs
    difficulty : silver 1
    velog : https://velog.io/@dnwlsrla40/DFS-%EC%96%91
 */

public class BoJ3184 {
    static int n,m;
    static String[][] map;
    static boolean[][] visit;
    static int[][] check = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int ocount, vcount = 0;


    public static void dfs(int x, int y){
        if(map[x][y].equals("o"))
            ocount++;
        if(map[x][y].equals("v"))
            vcount++;
        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];
            if(0 <= dx && dx < n && 0 <= dy && dy < m){
                if(!visit[dx][dy] && !map[dx][dy].equals("#")){
                    visit[dx][dy] = true;
                    dfs(dx, dy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new String[n][m];
        visit = new boolean[n][m];
        int o = 0, v = 0;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && !map[i][j].equals(".") && !map[i][j].equals("#")){
                    visit[i][j] = true;
                    ocount = 0;
                    vcount = 0;
                    dfs(i, j);
                    if(ocount > vcount)
                        o += ocount;
                    else
                        v += vcount;
                }
            }
        }
        System.out.println(o + " " + v);
        br.close();
    }
}
