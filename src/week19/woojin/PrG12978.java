package week19.woojin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrG12978 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N+1][N+1];
        int[] dis = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i < N+1; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int value = road[i][2];
            if(graph[start][end] > value){
                graph[start][end] = value;
                graph[end][start] = value;
            }

        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        dijkstra(pq, graph, 1, dis);
        for(int i = 1; i < N+1; i++){
            if(dis[i] <= K){
                answer++;
            }
        }

        return answer;
    }

    public void dijkstra(PriorityQueue<int[]> pq, int[][] graph, int start, int[] dis){
        dis[start] = 0;
        pq.add(new int[]{dis[start], start});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int pStart = temp[1];
            int pDis = temp[0];

            for(int i = 1; i < graph.length; i++){
                int endDist = graph[pStart][i];

                if(endDist != Integer.MAX_VALUE){

                    if(dis[i] > dis[pStart] + endDist){
                        dis[i] = dis[pStart] + endDist;
                        pq.add(new int[]{dis[i], i});
                    }
                }
            }
        }
    }
}
