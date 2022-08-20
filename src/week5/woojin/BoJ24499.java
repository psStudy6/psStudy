package week5.woojin;

/*
    Site : BOJ 백준 사이트
    title : blobyum
    number : 24499
    subject : slicing window
    difficulty : silver 4
 */

import java.io.*;

public class BoJ24499 {
    public static int solution(int n, int k, int[] delicious){
        int answer = 0;
        int[] sum = new int[n];
        for (int i = 0; i < k; i++) {
            answer += delicious[i];
        }
        sum[0] = answer;
        // dp 방법 (O(n) 방법)
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] - delicious[i-1] + delicious[i+k-1];
            if(sum[i] > answer)
                answer = sum[i];
        }

        // O(n^2) 방법 (slicing window)
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < i+k; j++) {
//                if(j >= n)
//                    sum += delicious[j-n];
//                else
//                    sum += delicious[j];
//            }
//            answer = Math.max(answer, sum);
//        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] delicious = new int[(2*n)];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            delicious[i] = Integer.parseInt(input[i]);
            delicious[i+n] = Integer.parseInt(input[i]);
        }
        bw.write(String.valueOf(solution(n, k, delicious)));
        bw.flush();
        bw.close();
        br.close();
    }

}
