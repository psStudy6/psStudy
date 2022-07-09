package week3.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/** 백준 6571 피보나치의 개수
 * 실버3
 * 
 * 문제 : 두 수 a와 b가 주어졌을 때, 구간 [a, b]에 포함되는 피보나치 수의 개수를 구하는 프로그램
 * 		입력의 마지막 줄에는 0이 두 개 주어진다. (a ≤ b ≤ 10100)
 * 		두 수 a와 b는 불필요한 0으로 시작하지 않는다.
 * 
 * 핵심 : ..실패...
*/
public class BoJ6571 {
	
	public int solution(long a, long b) {
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BoJ6571 boJ = new BoJ6571();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] str = br.readLine().split(" ");
			long a = Long.parseLong(str[0]);
			long b = Long.parseLong(str[1]);
			if (a == 0 && b == 0) {
				break;
			}
			sb.append(boJ.solution(a, b)).append("\n");
		}
		br.close();
		System.out.println(sb.toString());
	}
}
