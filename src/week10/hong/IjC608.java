/**
 * 문제 제목 : 이분검색
 * 강의 시청 : ✔️
 */

package week10.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IjC608 {
    /**
     * 설명
     * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
     * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
     *
     * 입력
     * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
     * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
     *
     * 출력
     * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
     */

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터 분할
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int sta = Integer.parseInt(temp[1]);

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int s : arr) {
            if(s <= sta) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
