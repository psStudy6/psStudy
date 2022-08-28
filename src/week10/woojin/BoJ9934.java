package week10.woojin;

/*
    Site : BOJ 백준 사이트
    title : 완전 이진 트리
    number : 9934
    subject : binary tree
    difficulty : silver 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BoJ9934 {
    private static int num,n;
    private static int[] arr;
    private static ArrayList<Integer>[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = (int) Math.pow(2,n) - 1;
        arr = new int[num];
        level = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            level[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        binarySearch(0,num-1,0);

        for (int i = 0; i < n; i++) {
            for (Integer integer : level[i]) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
        br.close();
    }

    public static void binarySearch(int low, int high, int height){
        if(height == n){
            return;
        }
        int mid = (low + high) / 2;
        level[height].add(arr[mid]);
        binarySearch(low, mid-1, height+1);
        binarySearch(mid+1, high, height+1);
    }
}
