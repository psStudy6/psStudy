package week11.yumi;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/** 프로그래머스 1844 게임 맵 최단거리
 * 레벨2
 * 
 * 문제 : 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 
 * 		캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
 * 		캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return
 * 		단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return
 * 		maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리
 * 		처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 * 
 * 핵심 : bfs - 너비 우선 탐색 = 최단 거리
 * 		변수명 조심하자!! 확인 또 확인! 조심 또 조심! ㅠ^ㅠ
*/


// 위치 정보
class Pos {
	int x;
	int y;
	int cnt;
	
	public Pos(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class PrG1844 {
	
	public static int[][] posArr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static boolean[][] visited;
	public static int m, n, min;
	
	
	/*방법 1 : bfs - 너비 우선 탐색 = 최단 거리 - queue
	 * 정확성: 69.9
	 * 효율성: 30.1
	 * 합계: 100.0 / 100.0
	*/
	public int solution(int[][] maps) {
		m = maps.length;
		n = maps[0].length;
		visited = new boolean[m][n];
		Queue<Pos> que = new LinkedList<>();
		// 항상 0, 0 에서 시작
		que.offer(new Pos(0, 0, 1));
	    visited[0][0] = true;
	    
		while (!que.isEmpty()){
			Pos pos = que.poll();
			int posX = pos.x;
			int posY = pos.y;
			// 팀 진영에 도착하면 최솟값 츨력
			if (posX == m-1 && posY == n-1) {
				return pos.cnt;
			}
			// 각 칸은 벽(-1)을 제외한 인접한 상하좌우 칸으로 이동 가능 
			for (int i = 0; i < posArr.length; i++) {
				int movePosX = posX + posArr[i][0];
				int movePosY = posY + posArr[i][1];
				// 범위 벗어날 시
				if (!isRange(maps, movePosX, movePosY)) {
					continue;
				}
				// 방문 표시 및 que 추가
	            visited[movePosX][movePosY] = true;
				que.offer(new Pos(movePosX, movePosY, pos.cnt + 1));
			}
		}
		// 팀 전영에 도달할 방법 없을 시
		return -1;
	} 
	
	// 범위 체크
	public boolean isRange(int[][] maps, int posX, int posY) {
		// 필드 외 영역 제외
		if (posX < 0 || posX >= m || posY < 0 || posY >= n) {
			return false;
		}
		// 벽 또는 방문한 곳일 경우 제외
		if (maps[posX][posY] == 0 || visited[posX][posY]){
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	/*방법 2 : dfs - 깊이 탐색 후 비교하므로 효율성 떨어짐 - 범위가 넓을 때 실패
	 *정확성: 69.9
	 *효율성: 0.0 (효율성 테스트 4개 모두 통과 못함)
	 *합계: 69.9 / 100.0 
	 */
	public int solution2(int[][] maps) {
		m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
		min = Integer.MAX_VALUE;
		
		dfs(maps, 0, 0, 1);
		return  min == Integer.MAX_VALUE ? -1 : min;
	}
	
	public void dfs(int[][] maps, int posX, int posY, int cnt) {
		// 방문 체크
		visited[posX][posY] = true;
		// 적 팀 진영 도달 시 최단 경로 세팅
		if (posX == m-1 && posY == n-1) {
			min = Math.min(min, cnt);
			return;
		}
		// 4방향 탐색
		for (int i = 0; i < posArr.length; i++) {
			int moveX = posX + posArr[i][0];
			int moveY = posY + posArr[i][1];
			// 범위가 아닐 시 탐색 안 함
			if (!isRange2(maps, moveX, moveY)) {
				continue;
			}
			// 탐색
			dfs(maps, moveX, moveY, cnt+1);
			// 미방문으로 변경
			visited[moveX][moveY] = false;
		}
		// 4방향을 다 돌면 방문으로 체크
		visited[posX][posY] = true;
	}
	
	// 범위 체크
	public boolean isRange2(int[][] maps, int posX, int posY) {
		// 필드 외 영역 제외
		if (posX < 0 || posX >= m || posY < 0 || posY >= n) {
			return false;
		}
		// 벽 또는 방문한 곳일 경우 제외
		if (visited[posX][posY] || maps[posX][posY] == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		PrG1844 prg = new PrG1844();
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		//int[][] maps2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
		
		System.out.println(prg.solution2(maps));
	}
}
