package week3.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 백준 6571 피보나치의 개수
 * 실버3
 * 
 * 문제 : 두 수 a와 b가 주어졌을 때, 구간 [a, b]에 포함되는 피보나치 수의 개수를 구하는 프로그램
 * 		입력의 마지막 줄에는 0이 두 개 주어진다. (a ≤ b ≤ 10^100)
 * 		두 수 a와 b는 불필요한 0으로 시작하지 않는다.
 * 
 * 핵심 : 1. 입력값이 10^100임을 고려하여 StringTokenizer, BigInteger 사용
 * 			- String, int, long  모두 NumberFormatException 오류 발생 
 *  	 2. f1 : 1, f2 : 2 이므로 1, 2 부터 시작
 *  		- 피보나치 수는 1, 2, 3, 5 로 시작
*/
public class BoJ6571 {
	
	public long solution(BigInteger a, BigInteger b) {
		// 선입 선출이 가능한 queue 사용
		Queue<BigInteger> que = new LinkedList<BigInteger>();
		// 0, 1 : 피보나치 수는 1, 2, 3, 5 로 시작함 
		// -> 0으로 시작하면 que.poll() 0 + que.peek() 1 = 1 
		// -> que.add(1) , que.poll() 1 + que.peek() 1 = 2 로 1부터 모든 피보나치 수를 탐색 가능 
		que.add(BigInteger.ZERO);
		que.add(BigInteger.ONE);
		BigInteger fb = BigInteger.ZERO;
		long cnt = 0; 
		
		while (true) {
			// 피보나치 수 : f(i-2) + f(i-1) = f(i) 
			fb = que.poll().add(que.peek());
			// a <= f <= b
			if (fb.compareTo(a) >-1 && fb.compareTo(b) < 1) {
				cnt++;
			}
			// 입력 범위 벗어나는 경우
			if (fb.compareTo(b) > -1) {
				break;
			}
			que.add(fb);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BoJ6571 boJ = new BoJ6571();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			
			if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) {
				break;
			}
			System.out.println(boJ.solution(a, b));
		}
		sc.close();
	}
	
	
	
	
	
	
	/* 오답 원인
	 * 입출력
	 * 	1. String으로는 10^100*2 + 1 까지 담을 수 없음. str.split(" ") 오류
	 * 		-> StringTokenizer를 사용해야 함
	 *  2. 10^100 까지 담으려면 long이 아닌 BigInteger 를 사용해야 함
	 *  
	 *  알고리즘
	 *  3. f1 : 1, f2 : 2 이므로 1을 두 번 넣을 필요 없음
	 *     1, 1 부터 시작, fb가 1로 시작하면 a가 1일 때 if문 조건이 필요하며 cnt+2가 아닌 cnt+1이어애 함 (조건, 실행코드 모두 잘못됨)
	 *  	-> 1, 2 부터 시작, fb가 0으로 시작하면 if문 줄 일 수 있음 
	 *  4. for(fb <= b)는 
	 *  	-> while(true)를 사용하며 안에 break문을 써야 함
	 */ 
	// 기존 오답
	public int solution_Err(long a, long b) {
		Queue<Long> que = new LinkedList<Long>();
		que.add((long) 1);
		que.add((long) 1);
		long fb = 1;
		int cnt = 0; 
		if (a == 1) {
			cnt += 2;
		}
		while (fb <= b) {
			fb = que.poll() + que.peek();
			que.add(fb);
			if (fb >= a && fb <= b) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main_Err(String[] args) throws NumberFormatException, IOException {
		BoJ6571 boJ = new BoJ6571();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] str = br.readLine().split(" ");
			BigInteger a = new BigInteger(str[0]);
			BigInteger b = new BigInteger(str[1]);
			if (a.equals(BigInteger.ZERO) && a.equals(BigInteger.ZERO)) {
				break;
			}
			sb.append(boJ.solution(a, b)).append("\n");
		}
		br.close();
		System.out.println(sb.toString());
	}
}
