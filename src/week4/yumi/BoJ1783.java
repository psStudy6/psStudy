package week4.yumi;

import java.util.Scanner;

/** 백준 1783 병든 나이트
 * 실버4
 * 
 * 문제 설명 : 
 * 이동방법 ) 1. y+2, x+1
 * 			2. y+1, x+2
 * 			3. y-1, x+2
 * 			4. y-2, x+1
 * 
 * - 병든 나이트의 이동 횟수가 4번보다 적지 않다면, 이동 방법을 모두 한 번씩 사용해야 한다. (방법마다 1회 이상씩 사용)
 * 	 이동 횟수가 4번보다 적은 경우(방문한 칸이 5개 미만)에는 이동 방법에 대한 제약이 없다.
 * 
 * 
 * 핵심 :
 * -> 1. 이동 횟수 < 5 ) 방법 제한 없음 = min(4, ~)
 * 	     이동 횟수 >= 5 ) 방법마다 1회 이상씩 사용 = 최댓값 - 방법 1번씩 사용한 최소칸 + 이동칸
 * 
 * 	  2. 가로) 한 번 지나간 가로는 뒤돌아가지 않음 -> 무조건 증가
 * 	     세로) +1 -1 가능함
 * 		-> 세로 1, 2, 3 기준으로 규칙 찾기
*/
public class BoJ1783 {
	
	public int solution(int n, int m) {
		// 세로 n = 1 : 나이트 위치가 1에서 시작이라 이동 불가 = 현재 위치 1
		if (n == 1) {
			return 1;
		}
		// 세로 n = 2 : y+1인 2번, 3번만 사용 가능 -> x+2 이므로 2칸마다 존재 = (m+1)/2
		// min(4, (m+1)/2) : 2개의 방법만 사용 가능하므로 최대 4번만 이동 가능
		if (n == 2) {
			return Math.min(4, (m+1)/2);
		}
		// 세로 n >= 3 : 1번, 4번 사용하여 최솟값, 최댓값 가능 -> x+1 이므로 1칸마다 존재 = m
		// 가로 m < 7 : 1~4번을 모두 한 번 씩 섰을 때 최소 1+2+2+1 = 6 + 1(현재칸) = 7칸 필요, 4번 이동, 5 위치 = min(4, m)
		if (m < 7) {
			return Math.min(4, m);
		}
		// 세로 > 3 && 가로 m > 8 : 최소 1회씩 사용 가정 4번 이동 시 필요한 최솟값 7칸, 5 위치 / 
		//						이후 1, 4번하여 최대 m개 이동 가능 => m-7+5 
		return m - 7 + 5;
	}
	
	public static void main(String[] args) {
		BoJ1783 boJ = new BoJ1783();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(boJ.solution(n, m));
		sc.close();
	}
}
