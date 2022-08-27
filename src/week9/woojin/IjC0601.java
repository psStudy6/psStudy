package week8.woojin;

/*
    Site : Infrean Java Coding Site
    title : 선택정렬
    number : 06강 01번
    subject : sort
    my velog link :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IjC0601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            int mIndex = i;
            int min = arr[i];
            int temp = arr[i];
            for (int j = i+1; j < n; j++) {
                if(min > arr[j]){
                    mIndex = j;
                    min = arr[j];
                }
            }
            arr[i] = min;
            arr[mIndex] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        br.close();
    }
}
