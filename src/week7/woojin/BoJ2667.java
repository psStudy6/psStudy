package week7.woojin;


/*
    Site : BOJ 백준 사이트
    title : 단지번호붙이기
    number : 2667
    subject : dfs, bfs
    difficulty : silver 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoJ2667 {
    private static int n, count, area = 0;
    private static int[][] map;
    private static boolean[][] visit;
    private static final int[][] check = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static List<Integer> result = new ArrayList<>();

    
    // bfs로도 가능 할 텐대 dfs가 편해서 dfs로 함
    public static void dfs(int x, int y) {
        count++;
        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];
            if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                if (!visit[dx][dy] && map[dx][dy] == 1) {
                    visit[dx][dy] = true;
                    dfs(dx, dy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    count = 0;
                    visit[i][j] = true;
                    area++;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);

        System.out.println(area);
        for (Integer integer : result) {
            System.out.println(integer);
        }
        br.close();
    }
}
