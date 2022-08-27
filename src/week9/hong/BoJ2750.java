/**
 * 등록 번호 : 2750번
 * 등록 제목 : 수 정렬하기2
 * 현재 상태 : 성공 ✔️
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BoJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // SelectCount Search
        int[] arr = new int[T];

        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int x : arr) {
            System.out.println(x);
        }
    }
}
