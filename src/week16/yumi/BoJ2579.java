package week16.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/* 백준 2579 계단 오르기
 * 
 * 0-1-- 3-4
 * 0-1-2-- 4-5
 * 0-- 2-3-- 5
 * 0-- 2-- 4
*/
public class BoJ2579 {
	
	private static int n;
	private static int[] step, score;
	
	private int solution() {
		score[1] = step[1];
		score[2] = step[1] + step[2]; // 시작점은 계단에 포함되지 않음
		score[3] = Math.max(step[1], step[2]) + step[3];
		
		for (int i = 4; i <= n; i++) {
			score[i] = Math.max(score[i - 3] + step[i - 1], score[i - 2]) + step[i];
		}
		return score[n];
	}
	
	public static void main(String[] args) throws IOException {
		BoJ2579 boj = new BoJ2579();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		step = new int[n + 1];
		score = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(boj.solution());	
	}
}
