package week11.hong;

import java.util.*;

/**
 * 제목 : 값이 k인 트리 노드의 깊이(실버2)
 * 성공 여부 : Success or "false"
 * 문제
 * n개의 정점과 n - 1개의 간선으로 구성된 트리 T가 있다. 정점 번호는 0부터 n - 1까지이고 0번 정점이 루트이다.
 * 간선에는 가중치가 없다. 트리 T에 있는 각 정점에는 서로 다른 값이 부여된다.
 * 트리 T에서 정점에 부여된 값이 k인 노드의 깊이(depth)를 출력하자.
 * 루트 정점의 깊이는 0이고 자식 정점의 깊이는 부모 정점의 깊이보다 1만큼 더 큰 값을 갖는다.
 *
 * 입력
 * 첫 번째 줄에 정점의 수 n과 정수 k가 공백을 사이에 두고 순서대로 주어진다.
 *
 * 두 번째 줄부터 n - 1개 줄에 걸쳐 간선의 정보가 주어진다. 한 줄에 하나의 간선 정보가 주어진다.
 * 하나의 간선 정보는 부모 정점 번호 p와 자식 정점 번호 c가 공백을 사이에 두고 순서대로 주어진다.
 *
 * 다음 줄에는 0번 정점부터 n - 1번 정점까지 각 정점에 부여된 값이 공백을 사이에 두고 순서대로 주어진다.
 * 즉, i번째 수는 i - 1(?)번 정점에 부여된 값을 의미한다.
 *
 * 출력
 * 첫 번째 줄에 정점에 부여된 값이 k인 정점의 깊이를 출력한다.
 *
 * 제한
 * 2 ≤ n ≤ 100,000
 * 0 ≤ k ≤ n - 1
 * 0 ≤ p, c ≤ n - 1, p ≠ c
 * 간선들로 만들어진 그래프는 트리이다.
 * 0 ≤ 정점에 부여된 값 ≤ n - 1
 * 각 정점에 부여된 값은 서로 다른 정수이다.
 *
 * # 해석
 * 1 번째 8-1(n) 5(k)
 * 부여된 값이 5인 정점은 정점 5번이다. 정점 5번의 깊이는 2이다.
 *   I0   I1   I2   I3          I1   I2   I3   I4   I5
 *           0            D0              0
 *        1    2          D1          1        2
 *   3    4   "5"   6     D2    3    4    "5"  6    7
 *                  7     D3
 *  왼쪽이 맞는 로직임 오른쪽은 이해 못해서 다른 방식인가 짠 방식.
 *  0 1 2 3 4 5 6 7 -> 순서인거는 알겠는데 마지막이 7이 되어야하는게 정상아닌가?
 *  아... 1번째 2번째 "5"가 몇번째 깊이인지 고르는 이야기구나..
 *  바보..
 *
 * Input
 * 0 - 8 5
 * 1 - 0 1
 * 2 - 0 2
 * 3 - 1 3
 * 4 - 1 4
 * 5 - 2 5
 * 6 - 2 6
 * 7 - 6 7
 * 순서 - 0 1 2 3 4 5 6 7  - 의미 없음
 *
 * OutPut
 * 2
 */

public class BoJ25511 {
        static int N, E, startPoint;
        static int[][] graph;
        static int pos;
        static boolean[] valCheck;
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            // write your code here
            N = sc.nextInt();
            E = sc.nextInt();
            startPoint = 0;

            graph = new int[1001][1001];
            valCheck = new boolean[N];

            //인접행렬
            int v1, v2;
            for(int i=1; i<=N; i++) {
                v1 = sc.nextInt();
                v2 = sc.nextInt();

                graph[v1][v2] = 1;
                graph[v2][v1] = 1;
            }
            bfs(startPoint, E);
        }

        static void bfs(int startPoint,int E) {
            Queue<Integer> queue = new LinkedList<>();

            // 시작지점
            valCheck[startPoint] = true;
            queue.offer(startPoint);
            int level = 0; // 높이

            while (!queue.isEmpty()) { // 큐 == null
                // System.out.println("========== level: " + level + " ==========");

                int qSize = queue.size();
                for(int i=1; i<=qSize; i++) {
                    pos = queue.poll();
                    // System.out.println(pos + " ");

                    if(pos == E) { System.out.println(level); break;};

                    //인접영역 탐색
                    for(int j=1; j<=N; j++) {
                        if( graph[pos][j]==1 && valCheck[j]==false ) {
                            queue.offer(j);
                            valCheck[j] = true;
                        }
                    }
                }
                level++;
            }

        }

}
