package week19.yumi;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프로그래머스 12978 배달
 *
 * 다익스트라 알고리즘 - 우선순위큐 사용
 */
class Graph {
    private int townCnt;
    private int maps[][];

    public Graph(int n) {
        this.townCnt = n;
        maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                maps[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    class Road implements Comparable<Road> {
        private int index;
        private int distance;

        public Road(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Road o) {
            return this.distance - o.distance;
        }
    }

    public void input(int town1, int town2, int distance) {
        // 동일한 루트, 다른 도로일 경우 작은 값 세팅
        if (maps[town1][town2] <= distance) {
            return;
        }
        maps[town1][town2] = distance;
        maps[town2][town1] = distance;
    }

    public int[] dijkstra(int start) {
        Queue<Road> queue = new PriorityQueue<>();
        int distances[] = new int[townCnt];

        // 시작점 - 마을 거리 세팅
        for (int i = 0; i < townCnt; i++) {
            if (i == start) {
                continue;
            }
            // 직행이 없는 경우 무한으로 세팅
            if (maps[start][i] == 0) {
                distances[i] = Integer.MAX_VALUE;
                continue;
            }
            // 직행 세팅
            distances[i] = maps[start][i];
            queue.add(new Road(i, maps[start][i]));
        }
        return findMinDistance(start, queue, distances);
    }

    private int[] findMinDistance(int start, Queue<Road> queue, int[] distances) {
        boolean[] visited = new boolean[townCnt];
        // 시작점 초기화
        distances[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            // 가장 인접한 마을
            int minIdx = queue.poll().index;
            visited[minIdx] = true;

            for (int i = 0; i < townCnt; i++) {
                // maps[minIdx][i] = Integer.MAX_VALUE 일 경우 1이상 값이 더 해지면 음수로 변경되기 때문에 제약 필요
                if (visited[i] || maps[minIdx][i] == Integer.MAX_VALUE) {
                    continue;
                }
                // 최소 이동 거리(A-..->B) + 다음 이동 거리(B->C) < 최소 이동 거리(A-..->C)
                if (distances[minIdx] + maps[minIdx][i] < distances[i]) {
                    distances[i] = distances[minIdx] + maps[minIdx][i];
                    queue.add(new Road(i, distances[i]));
                }
            }
        }
        return distances;
    }

    public int delivery(int[] distances, int start, int possibleDistance) {
        int count = 0;
        for (int i = 0; i < distances.length; i++) {
            System.out.print(distances[i] + ", ");
            // 배달 가능할 경우
            if (distances[i] <= possibleDistance) {
                count++;
            }
        }
        return count;
    }
}

public class PrG12978_v2 {

    public static void main(String[] args) {
        PrG12978_v2 prg = new PrG12978_v2();
        int n = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int k = 4;
        /*int n = 6;
        int[][] road = {{1, 4, 1}, {6, 3, 5}, {5, 3, 1}, {3, 1, 5}, {3, 4, 3}, {2, 3, 3}, {4, 2, 2}, {5, 6, 2}, {2, 1, 2}, {4, 5, 1}};
        int k = 3;*/
        System.out.println(prg.solution(n, road, k));
    }

    public int solution(int N, int[][] road, int K) {
        Graph graph = new Graph(N);
        // 마을 정보 세팅
        for (int i = 0; i < road.length; i++) {
            graph.input(road[i][0] - 1, road[i][1] - 1, road[i][2]);
        }
        return graph.delivery(graph.dijkstra(0), 0, K);
    }
}
