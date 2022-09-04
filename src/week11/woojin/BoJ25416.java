package week11.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
    Site : BOJ 백준 사이트
    title : 빠른 숫자 탐색
    number : 25416
    subject : bfs
    difficulty : silver 2
    velog : https://velog.io/@dnwlsrla40/BFS-%EB%B9%A0%EB%A5%B8-%EC%88%AB%EC%9E%90-%ED%83%90%EC%83%89
 */

public class BoJ25416 {
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

    static Queue<Node> q = new LinkedList<>();
    static int[][] map;
    static boolean[][] visit = new boolean[5][5];
    static int[][] check = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = node.x + check[i][0];
                int dy = node.y + check[i][1];
                if(0 <= dx && dx < 5 && 0 <= dy && dy < 5){
                    if(map[dx][dy] == 1){
                        return node.count + 1;
                    }
                    if(!visit[dx][dy] && map[dx][dy] == 0){
                        visit[dx][dy] = true;
                        q.add(new Node(dx, dy, node.count+1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        q.add(new Node(x, y, 0));
        visit[x][y] = true;
        System.out.println(bfs());
        br.close();
    }
}
