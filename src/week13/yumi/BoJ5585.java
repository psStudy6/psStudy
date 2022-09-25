package week13.yumi;

import java.util.Scanner;

/** 백준 5585 거스름돈
 * 
 * 문제 : JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 
 * 		타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램
*/
public class BoJ5585 {
	
	public static int[] arr = {500, 100, 50, 10, 5, 1};
	
	public int solution(int money) {
		int cnt = 0;
		// 동전 내림차순으로 탐색
		for (int i = 0; i < arr.length; i++) {
			if (money == 0) {
				break;
			}
			while (money >= arr[i]) {
				money -= arr[i];
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		BoJ5585 boj = new BoJ5585();
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		System.out.println(boj.solution(1000 - money));
		sc.close();
	}
}
