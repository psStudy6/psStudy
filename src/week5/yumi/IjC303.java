package week5.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 3-3 최대 매출
 * 
 * 문제 : N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
*/
public class IjC303 {
    
    // 방법 2
    public int solution2(int n, int k, int[] arr) {
        int max = 0, sum = 0;
        // 최초 1회 합계 구함
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < n; i++) {
            sum += - arr[i] + arr[i+k-1];
            max = Math.max(max, sum);                                                                                                                             
        }
        return max;
    }
    
    
    
    // 방법 1
    public int solution(int n, int k, int[] arr) {
        int max = 0, preSum = 0, sum = 0;
        // 최초 1회 합계 구함
        // i=0 ~ k 개의 합
        for (int i = 0; i < k; i++) {
            preSum += arr[i];
            max = preSum;
        }
        for (int i = 1; i < n; i++) {
            if(i+k > n) {
                break;
            }
            // i부터 K개의 합 = i-1부터 K개의 합 - 맨앞(i-1) + 맨뒤(i+k-1)
            sum = preSum - arr[i-1] + arr[i+k-1];
            preSum = sum;
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BoJ24499 boJ = new BoJ24499();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(boJ.solution(n, k, arr));
    }
}