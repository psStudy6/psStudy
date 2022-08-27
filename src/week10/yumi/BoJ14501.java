package week10.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 14501 퇴사
 * 실버3
 * 
 * 문제 : 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
 * 		상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 
 * 		또한, N+1일째에는 회사에 없기 때문에 상담을 할 수 없다.
 * 		백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
 * 
 * 핵심 : 깊이우선탐색 - 현재 상담(day + Ti) 이후 날짜 중 최대 이익을 낼 수 있는 상담 탐색(for)  
*/
public class BoJ14501 {
	
	static int n, max;
	static int[][] arr;
	
	public void solution() {
		max = 0;
		
		// 1일 부터 n일까지 탐색 (상담 시작점)
		for (int i = 0; i < n; i++) {
			dfs(i + arr[i][0], arr[i][1]);
		}
	}
	
	// 깊이 우선 탐색(일자, 총합)
	public void dfs(int idx, int sum) {
		// 퇴사 이후 리턴
		if (idx > n) {
			return;
		}
		// max 세팅
		if (sum > max) {
			max = sum;
		}
		// 현재 상담 이후 탐색
		for (int j = idx; j < n; j++) {
			dfs(j + arr[j][0], sum + arr[j][1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BoJ14501 boj = new BoJ14501();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		boj.solution();
		System.out.println(max);
	}
}
