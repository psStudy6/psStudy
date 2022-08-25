/**
 * 문제 제목 : 마구간 정하기
 * 강의 시청 : ✔️
 */

package week10.hong;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 설명
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
 * 둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
 *
 * 출력
 * 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
 *
 * Input
 * 5 3
 * 1 2 8 4 9
 *
 * Output
 * 3
 */

public class IjC610 {
    public static void main(String[] args) throws IOException {
        IjC610 T = new IjC610();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int horse = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, horse, arr));
    }

    public int solution(int N, int horse, int[] arr) {
        int answer_room = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            // 마구간 설치 수가 말의 수 보다 많거나 같으면
            // ans 임시 할당 + 범위 축소
            if (count(arr, mid) >= horse) {
                answer_room = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer_room;
    }

    // 마구간을 설치할 장소 탐색
    private static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int pos : arr) {
            // 이 위치가 중앙 값보다 클때 마구간 설치
            if (pos - ep >= dist) {
                cnt++;
                // end position 설치장소로 재할당
                ep = pos;
            }
        }
        return cnt;
    }
}
