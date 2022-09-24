package week13.yumi;

import java.util.Scanner;

/** 백준 16953 A → B
 * 실버 2
 * 
 * 문제 : 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
 *       2를 곱한다.
 *       1을 수의 가장 오른쪽에 추가한다. 
 *       A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
 *       
 * 핵심 : 1의 자리가 1이 아닌 홀수가 올 수 없음
 * 		b -> a로 연산 (%2 와 -1 % 10 활용)
 * 		방법1 ) 그리디 함수 -> 조건에 따라 계속 진핸
 * 		방법2 ) bfs
 * 
 * 주의 : a -> b 로 탐색 시 long으로 해야 함
*/
public class BoJ16953 {
	
	public int solution(int a, int b) {
		int cnt = 1;
		// a -> b로 연산
		while (a < b) {
			b = mathNum(b);
			cnt++;
		}
		// a가 b보다 크다면 절대 a를 b로 만들 수 없으므로 종료
		if (a > b) {
			return -1;
		}
		return cnt;
	}
	
	public int mathNum(int b) {
		// 2를 곱한 경우
		if (b % 2 == 0) {
			return b / 2;
		}
		// 제일 오른쪽 자리에 1을 추가한 경우
		if ((b-1) % 10 == 0) {
			return (b - 1) / 10;
		}
		// 1의 자리가 1이 아닌 홀수가 올 수 없음 - ex) 1 17 
		return -1;
	}
		
	public static void main(String[] args) {
		BoJ16953 boj = new BoJ16953();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(boj.solution(a, b));
		sc.close();
	}
}
