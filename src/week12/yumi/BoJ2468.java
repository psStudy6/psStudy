package week12.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/** 백준 2468 안전 영역
 * 실버1
 * 
 * 문제 : 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다. 
 * 		이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
 * 		어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다. 
 * 		물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다
 * 		어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램
 * 
 * 핵심 : 빙하문제와 동일. 조건에 맞는 구역을 dfs로 탐색
 * 		주의 ) 아무 지역도 물에 잠기지 않을 수도 있다. => 비가 안내림 = 높이 0으로 잠기는 지역 없음 (지역의 높이는 1부터이므로)
 * 		
 */
public class BoJ2468 {
	
	public static int n, maxDepth;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public int solution() {
		int max = 0;
		// 높이
		for (int depth = 1; depth <= maxDepth; depth++) {
			int cnt = countFiled(depth);
			max = Math.max(max, cnt);
			clearVisited();
		}
		return max;
	}
	
	// 방문이력 초기화
	public void clearVisited() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	public int countFiled(int depth) {
		int cnt = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (visited[x][y] || arr[x][y] <= depth) {
					continue;
				}
				// 첫 방문이고 안 잠긴 지역인 경우 - 방문처리, dfs
				visited[x][y] = true;
				dfs(x, y, depth);
				// 안전영역 개수 ++
				cnt++;
			}
		}
		return cnt;
	}
	
	public void dfs(int x, int y, int depth) {
		// 4방향 탐색
		for (int i = 0; i < pos.length; i++) {
			int posX = x + pos[i][0];
			int posY = y + pos[i][1];
			if (!isRange(posX, posY, depth)) {
				continue;
			}
			// 첫 방문이고 안 잠긴 지역인 경우 - 방문처리, dfs
			visited[posX][posY] = true;
			dfs(posX, posY, depth);
		}
	}
	
	public boolean isRange(int posX, int posY, int depth) {
		// 범위 벗어난 경우
		if (posX < 0 || posX >= n || posY < 0 || posY >= n) {
			return false;
		}
		// 방문했거나 잠긴 경우
		if (visited[posX][posY] || arr[posX][posY] <= depth) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ2468 boj = new BoJ2468();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		maxDepth = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxDepth = Math.max(maxDepth, arr[i][j]);
			}
		}
		System.out.println(boj.solution());
	}
}
