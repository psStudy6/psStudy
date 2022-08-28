package week10.yumi;

import java.util.Scanner;

/** 백준 11729 하노이 탑 이동 순서
 * 실버1
 * 
 * 문제 : 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 
 * 		각 원판은 반경이 큰 순서대로 쌓여있다.
 * 		1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 		2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 		이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 * 
 * 핵심 : A, B, C 장대가 있을 때 A -> C로 모든 원판(n)을 옮기려면 방법은 다음과 같다.
 * 		1. 마지막 원판을 제외한 n-1 개의 원판을 B로 옮긴다. Hanoi(n-1) 
 * 		2. 마지막 원판을 C로 옯긴다. 1
 * 		3. B로 옮겼던 n-1개의 원판을 C로 옮긴다. Hanoi(n-1) 
 * 		Hanoi(n) = 2 * Hanoi(n-1) + 1 
 * 				 = 2ⁿ - 1
 * 		
 * 		짝수일 때는 첫 시작 ) A -> B
 * 		홀수일 때는 첫 시작 ) A -> C
 * 
 * 		진짜 옮기는게 아니라 출력만 하는 거임
 * 
 * 예시 : ㄱ, ㄴ, ㄷ 
 * 		hanoi(A, B, C, 3)
 * 			1.
 * 			hanoi(A, C, B, 2)
 * 				1. 
 * 				hanoi(A, B, C, 1) 
 * 					print(A - ㄱ -> C) 		>	A[ㄴ, ㄷ], B[], C[ㄱ]
 * 				2.  
 * 				print(A - ㄴ -> B)			>	A[ㄷ], B[ㄴ], C[ㄱ]
 * 				3. 
 * 				hanoi(C, A, B, 1)
 * 					print(C - ㄱ -> B)		> 	A[ㄷ], B[ㄱ, ㄴ], C[]
 * 			2. 
 * 			print(A - ㄷ -> C)				> 	A[], B[ㄱ, ㄴ], C[ㄷ]
 * 			3. 
 * 			hanoi(B, A, C, 2)
 * 				1. 
 * 				hanoi(B, C, A, 1)
 * 					print(B - ㄱ -> A)		> 	A[ㄱ], B[ㄴ], C[ㄷ]
 * 				2. 
 * 				print(B - ㄴ -> C)			>	A[ㄱ], B[], C[ㄴ, ㄷ]
 * 				3.
 * 				hanoi(A, B, C, 1)
 * 					print(A - ㄱ -> B)		> 	A[], B[], C[ㄱ, ㄴ, ㄷ]
 * 
*/


public class BoJ11729 {
	static int cnt;
	static StringBuffer sb;
	// 
	public void hanoi(int A, int B, int C, int n) {
		cnt++;
		
		// 장대에 남은 마지막 원판인 경우 출력
		if (n == 1) {
			sb.append(A + " " + C).append("\n");
			return;
		}
		
		// 1. A -> B ) 마지막 원판을 제외한 n-1 개의 원판을 B로 옮긴다. Hanoi(n-1) 
		hanoi(A, C, B, n-1);
		
		// 2. A -> C ) 마지막 원판을 C로 옯긴다.
		sb.append(A + " " + C).append("\n");
		
		// 3. B -> C ) B로 옮겼던 n-1개의 원판을 C로 옮긴다.
		hanoi(B, A, C, n-1);
	}
	
	
	public static void main(String[] args) {
		BoJ11729 boj = new BoJ11729();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cnt = 0;
		sb = new StringBuffer();
		
		boj.hanoi(1, 2, 3, n);
		
		System.out.println(cnt);
		System.out.println(sb.toString());
		
		sc.close();
	}
}
