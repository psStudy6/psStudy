package week19.yumi;

/**
 * 프로그래머스 12978 배달
 */
public class PrG12978 {

    static int townCnt;

    public static void main(String[] args) {
        PrG12978 prg = new PrG12978();
        int n = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int k = 4;
        System.out.println(prg.solution(n, road, k));
    }

    public int solution(int N, int[][] road, int K) {
        townCnt = N;
        int[][] distances = new int[townCnt][townCnt];
        // 직행값 세팅
        for (int i = 0; i < road.length; i++) {
            int country1 = road[i][0] - 1;
            int country2 = road[i][1] - 1;
            if (distances[country1][country2] != 0
                    && road[i][2] > distances[country1][country2]) {
                continue;
            }
            distances[country1][country2] = road[i][2];
            distances[country2][country1] = road[i][2];
        }
        for (int i = 0; i < townCnt; i++) {
            for (int j = 0; j < townCnt; j++) {
                if (i == j || distances[i][j] > 0) {
                    continue;
                }
                distances[i][j] = 100_000_000;
            }
        }
        return delivery(dijkstra(distances, 0), K);
    }

    // 다익스트라 알고리즘
    private int[] dijkstra(int[][] distances, int start) {
        int[] minDistance = new int[townCnt];
        boolean[] visited = new boolean[townCnt];

        // 1번 직행 세팅
        for (int i = 0; i < townCnt; i++) {
            minDistance[i] = distances[start][i];
        }
        visited[start] = true;

        // 전체 마을 수 - 최초 시작점(A) - 최초 시작점에서 가장 가까운 마을
        for (int i = 0; i < townCnt - 2; i++) {
            // 가장 까가운 마을 방문(B)
            int smallIndex = getSmallIndex(minDistance, visited);
            visited[smallIndex] = true;
            // 마을 직행 탐색
            for (int nextTown = 0; nextTown < townCnt; nextTown++) {
                if (visited[nextTown]) {
                    continue;
                }
                // 최소 이동 거리(A-..->B) + 다음 이동 거리(B->C) < 최소 이동 거리(A-..->C)
                if (minDistance[smallIndex] + distances[smallIndex][nextTown] < minDistance[nextTown]) {
                    minDistance[nextTown] = minDistance[smallIndex] + distances[smallIndex][nextTown];
                }
            }
        }
        return minDistance;
    }

    private int getSmallIndex(int[] minDistance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < townCnt; i++) {
            if (visited[i] || minDistance[i] >= min) {
                continue;
            }
            min = minDistance[i];
            idx = i;
        }
        // 가장 짧은 거리의 인덱스
        return idx;
    }

    private int delivery(int[] minDistance, int possibleDistance) {
        int count = 0;
        for (int distance : minDistance) {
            // 배달 가능할 경우
            if (distance <= possibleDistance) {
                count++;
            }
        }
        return count;
    }
}
