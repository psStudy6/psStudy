package week4.yumi;

import java.util.Scanner;

/** 인프런 2-5 소수(에라토스테네스 체)
 * 
 * 문제 : 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력
 * 
 * 핵심 : 소수의 배수는 소수가 아님
*/
public class ljC205 {
	// 방법 1
	public int solution(int n) {
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				cnt++;
			}
		}
		return cnt;
	}
	public boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 방법 2
	public int solution2(int n) {
		int cnt = 0;
		int[] arr = new int[n+1];
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				cnt++;
				for (int j = i; j <= n; j=j+i) {
					arr[j] = 1;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		ljC205 m = new ljC205();	
		Scanner sc = new Scanner(System.in);
		System.out.println(m.solution2(sc.nextInt()));
		sc.close();
	}
}
