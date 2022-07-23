package week5.woojin;

import java.io.*;

/*
    Site : BOJ 백준 사이트
    title : 수 정렬하기 3
    number : 10989
    subject : 정렬
    difficulty : bronze 1
 */


public class BoJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] counting = new int[10001];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            counting[arr[i]]++;
        }

        for (int i = 1; i < 10001; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = arr.length-1; i >= 0 ; i--) {
            int temp = arr[i];
            counting[temp]--;
            result[counting[temp]] = temp;
        }

        for (int i : result) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
