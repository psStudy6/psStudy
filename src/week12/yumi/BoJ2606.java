package week12.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 백준 2606 바이러스
 * 실버3
 * 
 * 문제 : 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 * 		어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
 * 		컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력
 * 
 * 핵심 : 인접 리스트 사용 ArrayList<ArrayList<Integer>>
 * 		주의) 1번을 제외해야 하여 개수 세야함
*/
public class BoJ2606 {
	// 인접 리스트 사용
	public static ArrayList<ArrayList<Integer>> list;
	public static boolean[] visited;
	
	public int solution() {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[list.size()];
		// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수이므로 1번 먼저 세팅
		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			ArrayList<Integer> comList = list.get(idx);
			for (int i = 0; i < comList.size(); i++) {
				int comIdx = comList.get(i);
				// 방문한 이력이 없는 컴퓨터만 추가
				if (!visited[comIdx]) {
					queue.add(comIdx);
					visited[comIdx] = true;
				}
			}
			cnt++;
		}
		// 1번을 제외해야 하므로 -1
		return cnt - 1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BoJ2606 boj = new BoJ2606();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Integer>>();
		// 인접 리스트 세팅
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		// 입력값 세팅
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int computer1 = Integer.parseInt(st.nextToken());
			int computer2 = Integer.parseInt(st.nextToken());
			// 양방향
			list.get(computer1).add(computer2);
			list.get(computer2).add(computer1);
		}
		System.out.println(boj.solution());
	}
}
