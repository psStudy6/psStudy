package week16.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 13305 주유소
 * 
 * 분류) 그리디
*/
public class BoJ13305 {
	
	// 방법 1 : 100점 - 성공
	//		  입력 시 minPrice값 비교 -> 합 구함
	private long solution(int n, long[][] arr) {
		long sum = 0;
		// 도시간 거리 * 도시별 최소 주유 가격
		for (int i = 0; i < n; i++) {
			sum += arr[i][0] * arr[i][1]; 
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ13305 boj = new BoJ13305();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()) - 1;
		long[][] arr = new long[n][2];
		// 도시간 거리 세팅
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		// 도시별 최소 주유 가격
		st = new StringTokenizer(br.readLine());
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int price = Integer.parseInt(st.nextToken());
			// 왼쪽부터 현도시까지 중 최소 주유가격 저장
			minPrice = Math.min(minPrice, price);
			arr[i][1] = minPrice;
		}
		System.out.println(boj.solution(n, arr));
	}
	
	
	// -----------------------------------------------
	
	private static int n2; 
	private static long min2;
	private static int[][] arr2;
	
	// 방법 2 : 17점 - 부분성공 - 반례를 못 찾음..
	//		  입력 받은 후 dfs
	private long solution2() {
		min2 = Integer.MAX_VALUE;
		find2(0, 0);
		return min2;
	}
	
	private void find2(int station, long sum) {
		if (station == n2) {
			min2 = Math.min(sum, min2);
			return;
		}
		int distance = 0;
		int price = arr2[station][1];
		for (int city = station; city < n2; city++) {
			distance += arr2[city][0];
			if (city != n2 - 1 && price <= arr2[city + 1][1]) {
				continue;
			}
			find2(city + 1, sum + price * distance);
		}
	}

	public static void main2(String[] args) throws IOException {
		BoJ13305 boj = new BoJ13305();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n2 = Integer.parseInt(br.readLine()) - 1;
		arr2 = new int[n2][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n2; i++) {
			arr2[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n2; i++) {
			arr2[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(boj.solution2());
	}
}
