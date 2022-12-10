import java.util.*;
/* PrG12978 배달
* 양방향 도로
* K = 이 시간 이하로 배달이 가능한 마을에서만 주문받음
*/
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        int[] dist = new int[N+1];
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        
실행 결과
        for(int i = 0; i < N+1; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int value = road[i][2];
            if(map[start][end] > value){
                map[start][end] = value;
                map[end][start] = value;
            }

        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(pQueue, map, 1, dist);
        for(int i = 1; i < N+1; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(PriorityQueue<int[]> pQueue, int[][] map, int start, int[] dist){
        dist[start] = 0;
        pQueue.add(new int[]{dist[start], start});
        
        while(!pQueue.isEmpty()){
            int[] pop = pQueue.remove();
            int popStart = pop[1];
            int popDist = pop[0];
            
            for(int i = 1; i < map.length; i++){
                int endDist = map[popStart][i];
                
                if(endDist != Integer.MAX_VALUE){
                    
                    if(dist[i] > dist[popStart] + endDist){
                        dist[i] = dist[popStart] + endDist;
                        pQueue.add(new int[]{dist[i], i});
                    }
                }
            }
            
        }
        
    }
}
