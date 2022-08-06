package week7.woojin;

/*
    Site : BOJ 백준 사이트
    title : DFS와 BFS
    number : 1260
    subject : dfs, bfs
    difficulty : silver 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BoJ1260 {
    private static int n;
    private static List<Integer>[] graph;

    public static void dfs(int node, boolean[] visit){
        System.out.print(node + " ");
        visit[node] = true;
        for (Integer i : graph[node]) {
            if(!visit[i]) {
                dfs(i, visit);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        q.add(v);
        visit[v] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for (Integer i : graph[node]) {
                if(!visit[i]){
                    visit[i]= true;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        boolean[] visit = new boolean[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            graph[s].add(e);
            graph[e].add(s);
        }

        // dfs에서 작은 거 먼저 들리게 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v, visit);
        System.out.println();
        bfs(v);
        br.close();
    }
}
