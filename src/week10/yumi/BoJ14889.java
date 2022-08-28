package week10.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 14889 스타트와 링크
 * 실버2
 * 
 * 문제 :  축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 
 * 		 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
 * 		 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 
 * 		 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
 * 		 Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
 * 		 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.
 */
public class BoJ14889 {
	
	static int n, min;
	static int[][] arr;
	static boolean[] t1;
	
	public void solution() {
		min = Integer.MAX_VALUE;
		t1 = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			t1[i] = true;
			dfs(i, 1, 0);
			t1[i] = false;
		}
	}
	
	public void dfs(int idx, int cnt, int sum) {
		if (cnt == n/2) {
			// t2 능력치
			int t2 = 0;
			for (int i = n-1; i >= 0; i--) {
				if (t1[i]) {
					continue;
				}
				t2 += getSum(i, false); 
			}
			
			// 능력치 차
			int dif = Math.abs(sum - t2);
			if (dif < min) {
				min = dif;
			}
			return;
		}
		
		// 깊이 우선 탐색
		for (int j = idx+1; j < n; j++) {
			// 같은 팀일 경우
			t1[j] = true;
			dfs(j, ++cnt, sum + getSum(j, true));
			// 초기화
			t1[j] = false;
			--cnt;
		}
	}
	
	// 한 선수i와 다른 선수j와의 능력치 합
	public int getSum(int idx, boolean isT1) {
		int sum = 0;
		
		for (int j = idx-1; j >= 0; j--) {
			// t1은 팀원일 때만
			if (isT1 && !t1[j]) {
				continue;
			}
			// t2은 t1팀원이 아닐때만
			if (!isT1 && t1[j]) {
				continue;
			}
			sum += arr[idx][j];
			sum += arr[j][idx];
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ14889 boj = new BoJ14889();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boj.solution();
		System.out.println(min);
	}
}
