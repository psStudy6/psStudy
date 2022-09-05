package week12.yumi;

import java.util.*;
import java.io.*;

/** 백준 1012 유기농 배추
 * 실버2
 * 
 * 문제 : 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
 * 		특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다. 
 * 		한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 * 		배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 * 		0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
 * 
 * 핵심 : 배추의 사방향 검사 시 다른 배추가 없으면 배추 1개에 지렁이 1마리
 * 		다른 배추가 있으면 인접해 있으므로 배추들 영역에 지렁이 1마리
 * 		=> 영역을 찾는 문제 = 깊이 우선 탐색 dfs  
 *
 */
public class BoJ1012
{
	public static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 사방향 - 오하좌상
	
	public int solution(int[][] arr, int m, int n, int carvage) {
		int cnt = 0;
		boolean[][] visited = new boolean[m][n];
		
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				// 배추가 아니거나 방문한 배추일 경우 탐색 안 함
				if (arr[x][y] != 1 || visited[x][y]) {
					continue;
				}
				// 방문 체크 후 dfs 시작
				visited[x][y] = true;
				dfs(arr, x, y, visited);
				// 배추영역당 지렁이 1마리
				cnt++;
			}
		}
		return cnt;
	}
	
	// dfs : 배추의 영역 탐색 
	public void dfs (int[][] arr, int x, int y, boolean[][] visited) {
		int m = arr.length;
		int n = arr[0].length;
		// 4방향 탐색
		for (int i = 0; i < pos.length; i++) {
			int posX = x + pos[i][0];
			int posY = y + pos[i][1];
			// 범위가 아니거나 이미 방문한 지역은 패스
			if (!isRange (posX, posY, m, n) || visited[posX][posY]) {
				continue;
			}
			// 방문 체크
			visited[posX][posY] = true;
			// 인접한 배추가 있다면 해당 배추의 인접한 4방향 탐색 
			if (arr[posX][posY] == 1) {
				dfs (arr, posX, posY, visited);
			}
		}
	}
	
	// 범위 체크
	public boolean isRange(int posX, int posY, int m, int n) {
		if (posX < 0 || posX >= m || posY < 0 || posY >= n) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ1012 ts = new BoJ1012();
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()) ;
		StringBuffer sb = new StringBuffer();

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()) ;
			int n = Integer.parseInt(st.nextToken());
			int carvage = Integer.parseInt(st.nextToken());
			int[][] arr = new int[m][n];
			for (int i = 0; i < carvage; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			sb.append(ts.solution(arr, m, n, carvage)).append("\n"); 
		}
		System.out.println(sb);
	}
}
