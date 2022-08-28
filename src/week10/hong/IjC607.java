package week10.hong;

/**
 * 문제 제목 : 좌표 정렬
 * 강의 시청 : ✔️
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IjC607 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /**
         * 좌표 정렬 이기 때문에 해당 1열은 몇개가 들어올지 모른다.
         * 하지만 2열은 2개의 X,Y로 받기 때문에 고정값으로 받으면 된다.
         * int[][] arr = new int[정렬 되는 개수 : N][고정값 : 2]
         */
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (w1, w2) -> {
            if(w1[0] == w2[0]) {
                return w1[1] - w2[1];
            } else {
                return w1[0] - w2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< N ; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
