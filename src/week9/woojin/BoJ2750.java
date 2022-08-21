package week9.woojin;

import java.io.*;

/*
    Site : BOJ 백준 사이트
    title : 수 정렬하기
    number : 2750
    subject : Sort
    difficulty : bronze 2
 */

public class BoJ2750 {
    public static void sort(int[] arr){
        int temp;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++) {
                if(arr[i]<arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sort(arr);
        for (int i : arr) {
            sb.append(i).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
