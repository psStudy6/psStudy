package week11.yumi;

import java.io.IOException;

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
 * 결과 : 정확성: 69.9
 * 		효율성: 0.0 (효율성 테스트 4개 모두 통과 못함)
 * 		합계: 69.9 / 100.0
*/
public class PrG1844 {
	
	public static int[][] postArr = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	public static boolean[][] visited;
	public static int m, n, min;
	
	public int solution(int[][] maps) {
		m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
        
		min = Integer.MAX_VALUE;
		dfs(maps, m-1, n-1, 1);
		return  min == Integer.MAX_VALUE ? -1 : min;
	}
	
	public void dfs(int[][] maps, int posX, int posY, int cnt) {
		visited[posX][posY] = true;
		if (posX == 0 && posY == 0) {
			min = Math.min(min, cnt);
			return;
		}
		
		for (int i = 0; i < postArr.length; i++) {
			int moveX = posX + postArr[i][0];
			int moveY = posY + postArr[i][1];
			// 범위가 아닐 시 탐색 안 함
			if (!isRange(maps, moveX, moveY)) {
				continue;
			}
			dfs(maps, moveX, moveY, cnt+1);
			visited[moveX][moveY] = false;
		}
		visited[posX][posY] = true;
	}
	
	public boolean isRange(int[][] maps, int posX, int posY) {
		// 범위가 아닌 경우 리턴
		if (posX < 0 || posX >= m || posY < 0 || posY >= n) {
			return false;
		}
		if (visited[posX][posY] || maps[posX][posY] == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		PrG1844 prg = new PrG1844();
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		int[][] maps2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
		
		System.out.println(prg.solution(maps2));
		//System.out.println(prg.solution(maps2));
	}
}
