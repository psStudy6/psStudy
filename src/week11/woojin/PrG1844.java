package week11.woojin;

import java.util.LinkedList;
import java.util.Queue;

/*
    Site : Programmers Algorithm site
    title : 게임 맵 최단 거리
    number : 1844
    subject : bfs
    difficulty : level 2
    velog : https://velog.io/@dnwlsrla40/BFS-%EA%B2%8C%EC%9E%84-%EB%A7%B5-%EC%B5%9C%EB%8B%A8-%EA%B1%B0%EB%A6%AC
 */

public class PrG1844 {
    static Queue<Node> q = new LinkedList<>();
    static int[][] check = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n, m;
    static boolean[][] visit;
    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int bfs(int[][] map){
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.x == n-1 && node.y == m-1){
                return node.count;
            }
            for (int i = 0; i < 4; i++) {
                int dx = node.x + check[i][0];
                int dy = node.y + check[i][1];
                if(0 <= dx && dx < n && 0 <= dy && dy < m){
                    if(!visit[dx][dy] && map[dx][dy] == 1) {
                        visit[dx][dy] = true;
                        q.add(new Node(dx,dy,node.count+1));
                    }
                }
            }
        }
        return -1;
    }

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];

        q.add(new Node(0,0,1));
        visit[0][0] = true;

        return bfs(maps);
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
