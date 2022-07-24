package week5.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
    Site : BOJ 백준 사이트
    title : 먹을 것인가 먹힐 것인가
    number : 7795
    subject : Two Pointer
    difficulty : silver 3
 */

public class BoJ7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            Integer[] arrA = new Integer[n];
            int[] arrB = new int[m];
            boolean[] eat = new boolean[m];
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(input[i]);
            }
            input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(arrB);
            Arrays.sort(arrA, Collections.reverseOrder());
            Arrays.fill(eat, true);

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!eat[j])
                        break;
                    if(arrA[i] > arrB[j])
                        count++;
                    else {
                        eat[j] = false;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}
