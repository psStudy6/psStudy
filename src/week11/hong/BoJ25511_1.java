package week11.hong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class BoJ25511_1 {
    static int nV; // 정점의 수
    static int nE; // 간선의 수
    static int [][] arr2d; // 정점간 연결관계 저장 배열
    static boolean [] check; // 방문한 정점 체크 배열

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        nV = scan.nextInt(); // 정점입력
        nE = scan.nextInt(); // 간선입력

        System.out.println(nV + " / " + nE);

        arr2d = new int[nV + 1][nV + 1];
        check = new boolean[nV + 1];
        // 0이 아닌 1부터 비교할 거기 때문에
        // 모두 1씩 더해줌

        for (int i = 0; i < nE; i++) {
            int temp1 = scan.nextInt();
            int temp2 = scan.nextInt();

            System.out.println(temp1 + " / " + temp2);

            arr2d[temp1][temp2] = arr2d[temp1][temp2] = 1;
            // 간선간의 연결관계 체크 양방향 모두 체크
        }

        System.out.println(" < - 탐색시작위치 입력 - > ");
        int start = nE;
        System.out.println(">> : " + start);
        bfs(start);
    }
    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        // 선입선출( 먼저들어온것이 먼저 나간다.)
        // 의 특징을 가지는 큐를 활용해서 bfs 탐색을 시작
        q.offer(i);
        // 처음 시작지점 큐에 넣는다.

        while(!q.isEmpty()) {
            // 큐에 있는 모든 정점에 방문할때까지 반복
            int temp = q.poll();
            // 큐에 있는 방문한 정점을 하나 빼줌
            System.out.println("방문한 정점은 -> " + temp + " ");
            for(int j = 1; j < nV + 1; j++) {
                if(arr2d[temp][j] == 1 && check[j] == false) {
                    // 현재 정점에서 다음 j 에 정점과 연결되었는지 체크
                    // 연결되었으며, 기존에 방문한 정점인지 체크
                    q.offer(j);
                    // 모두 참이면 해당 정점 큐에 넣어줌
                    check[j] = true;
                    // 큐에 들어가면 확정방문 정점이기 때문에
                    // 방문배열 체크.
                }
            }
        }
    }

}
