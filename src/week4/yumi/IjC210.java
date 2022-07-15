package week4.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 2-10 봉우리
 * 
 * 문제 : 지도 정보가 N*N 격자판에 주어집니다. 
 * 		각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 		각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 
 * 		봉우리 지역이 몇 개 있는 지 알아내는 프로그램
 * 		격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 
 * 핵심 : 가장자리일 경우 0으로 항상 기준 점보다 작음
*/
public class IjC210 {
	static int[][] arr;
	static int n;
	int[][] pos = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
	
	public int solution(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cnt += isMoutain(i, j);
			}
		}
		return cnt;
	}
	// 봉우리 여부
	public int isMoutain(int i, int j) {
		for (int z = 0; z < pos.length; z++) {
			// 상하좌우가 격자 가장자리 일 경우 = 0 이므로 continue
			if (isEdge(i+pos[z][0]) || isEdge(j+pos[z][1])) {
				continue;
			}
			// 상하좌우 중에 더 큰 숫자가 있는 경우
			if (arr[i][j] <= arr[i+pos[z][0]][j+pos[z][1]]) {
				return 0;
			}
		}
		// 봉우리
		return 1;
	}
	// 격자 가장자리 여부
	public boolean isEdge(int tmp) {
		if (tmp < 0 || tmp >= n) {
			return true;
		}
		return false;
	}
	
	public static void main1(String[] args) throws IOException {
		IjC210 ijC = new IjC210();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		System.out.println(ijC.solution(arr));
	}
}
