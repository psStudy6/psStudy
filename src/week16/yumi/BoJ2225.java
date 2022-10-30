package week16.yumi;

import java.util.Scanner;

/** 백준 2225 합분해
 * 
 * 분류) DP
 * 
 *   | 0  1  2  3  4  5  6
 * -------------------------
 * 0 | 1  0  0  0  0  0  0
 * 1 | 1  1  1  1  1  1  1 
 * 2 | 1  2  3  4  5  6  7 
 * 3 | 1  3  6  10 15 21 28
 * 4 | 1  4  10 20 35 56 84
 * 
*/
public class BoJ2225 {
	
	public static long mod = 1000000000L;
	
	private long solution(int n, int k, long[][] arr) {
		// 0부터 이므로 0을 만들 수 있는 방법은 1개
		arr[0][0] = 1;
		
		// 1개 ~ k개
        for (int i=1; i<=k; i++) {
        	// 정수 0 ~ n
            for (int j=0; j<=n; j++) {
            	// arr[k개][정수n] = arr[k-1개][정수0] + .. + [정수n]
                for (int l=0; l<=j; l++) {
                    arr[i][j] += arr[i-1][j-l];
                    arr[i][j] %= mod;
                }
            }
        }
		// arr[k개][정수n]
		return arr[k][n];
	}
	
	public static void main(String args[]) {
		BoJ2225 boj = new BoJ2225();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 0포함 k+1, n+1
        long[][] arr = new long[k+1][n+1];
        
        System.out.println(boj.solution(n, k, arr));
    }
}
