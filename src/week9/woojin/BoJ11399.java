package week9.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    Site : BOJ 백준 사이트
    title : ATM
    number : 11399
    subject : Sort
    difficulty : silver 4
 */

public class BoJ11399 {
    
    // 그냥 sort를 이용한 방법 [메모리 : 14516KB, 시간 : 148ms]
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String[] input = br.readLine().split(" ");
//        int[] time = new int[n];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            time[i] = Integer.parseInt(input[i]);
//        }
//
//        Arrays.sort(time);
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                sum += time[j];
//            }
//        }
//
//        System.out.println(sum);
//        br.close();
//    }

    // memorization 이용한 방법 [메모리 : 14460KB, 시간 : 128ms]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] time = new int[n];
        int[] sum = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(time);

        sum[0] = time[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + time[i];
        }

        for (int i : sum) {
            result += i;
        }
        System.out.println(result);
        br.close();
    }

}
