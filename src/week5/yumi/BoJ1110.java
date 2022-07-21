package week5.yumi;

import java.util.Scanner;

/** 백준 1110 더하기 사이클
 * 브론즈1
 * 
 * 문제 : 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 
 * 		그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 
 * 		N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램
 * 
 * 핵심 : -
 * 
*/
public class BoJ1110 {
	
	public int solution(int num) {
		int cnt = 0;
		int bs = num;
		
		while(true) {
			// num%10*10 : 주어진 수의 가장 오른쪽 자리 수 * 10 
			// (num/10 + num%10) % 10 : 각 자리의 숫자 합의 가장 오른쪽 자리 수
		    num = num%10*10 + (num/10 + num%10) % 10;
			cnt++;
			// 사이클 종료
			if(bs == num) break;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		BoJ1110 boJ = new BoJ1110();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		System.out.println(boJ.solution(num));
	}
}
