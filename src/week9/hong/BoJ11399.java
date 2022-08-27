/**
 * 등록 번호 : 13399번
 * 등록 제목 : ATM
 * 현재 상태 : 성공 ✔️
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoJ11399 {
    public static void main(String[] args) throws IOException {
        BoJ11399 M = new BoJ11399();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr =new int[T];

        String str = br.readLine();
        String[] arrString = str.split(" ");
        int temp = 0;
        for(int i=0; i<T; i++) {
            temp = Integer.parseInt(arrString[i]);
            arr[i] = temp;
        }

        System.out.println(M.solution(T, arr));
    }

    public int solution(int T, int[] arr) {
        Arrays.sort(arr);

        int answer = 0;
        int wait = 0;

        for(int i=0; i<T; i++) {
            wait += arr[i];
            answer += wait;
        }
        return answer;
    }

}
