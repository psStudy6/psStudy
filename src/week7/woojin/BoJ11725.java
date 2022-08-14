package week7.woojin;


/*
    Site : BOJ 백준 사이트
    title : 트리의 부모 찾기
    number : 11725
    subject : 트리, 그래프
    difficulty : silver 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoJ11725 {
    private static List<Integer>[] graph;
    private static int n;
    private static int[] result;

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visit = new boolean[n+1];
        q.add(node);
        visit[node] = true;
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            // 연결된 노드 확인(여기서 새롭게 연결된 것은 자식 노드이므로 결과에 기록)
            for (Integer i : graph[temp]) {
                if(!visit[i]) {
                    visit[i] = true;
                    result[i] = temp;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 간선의 갯수 (n-1) 만큼 반복
        for (int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            graph[s].add(e);
            graph[e].add(s);
        }

        bfs(1);

        for (int i = 2; i < n+1; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }
}
