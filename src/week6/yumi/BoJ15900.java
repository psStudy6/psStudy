package week6.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 백준 15900 나무 탈출
 * 실버1
 * 
 * 문제 : N개의 정점이 있는 트리 모양으로 생긴 게임판과 몇 개의 게임말로 이루어진다. 
 * 		트리의 각 정점에는 1번부터 N번까지 번호가 붙어있다. 
 * 		1번 정점은 '루트 노드' 라고 불리며, 이 루트 노드를 중심으로 정점 간에 부모-자식 관계가 만들어진다. 
 * 		자식이 없는 노드는 '리프 노드' 라고 불린다.
 * 
 * 		처음에는 트리의 모든 리프 노드에 게임말이 하나씩 놓여있는 채로 시작한다.
 * 		어떤 사람의 차례가 오면, 그 사람은 현재 존재하는 게임말 중 아무거나 하나를 골라 그 말이 놓여있던 노드의 부모 노드로 옮긴다. 
 * 		이 과정에서 한 노드에 여러 개의 게임말이 놓이게 될 수도 있다. 
 * 		이렇게 옮긴 후에 만약 그 게임말이 루트 노드에 도착했다면 그 게임말을 즉시 제거한다. 
 * 		모든 과정을 마치면 다음 사람에게 차례를 넘긴다. 이런 식으로 계속 진행하다가 게임말이 게임판에 존재하지 않아 고를 수 없는 사람이 지게 된다.
*/
public class BoJ15900 {
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static int cnt = 0;
	
	// 루트노드 부터 아래로 검색
	public void dfs(int num, int distance) {
		visited[num] = true;
		for (int node : list.get(num)) {
			// 방문 안 한 경우
			if (!visited[node]) {
				dfs(node, distance + 1);
			}
		}
		// 리프노드일 경우
		if (list.get(num).size() == 1) {
			cnt += distance ;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BoJ15900 boJ = new BoJ15900();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		while (n-- > 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			list.get(node1).add(node2);
			list.get(node2).add(node1);
		}
		boJ.dfs(1, 0);
		System.out.println(cnt%2 == 0 ? "No" : "Yes");
	}
	
	//
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 정점개수 >= 2
		int[] arr = new int[n+1];
		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		while (n-- > 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			if (node1 == 1 || arr[node1] > 0) {
				arr[node2] = arr[node1] + 1;
				visited[node1] = true;
			} 
			else if (node1 == 1 || arr[node1] > 0) {
				arr[node1] = arr[node2] + 1;
				visited[node2] = true;
			}
		}
		for (int i = 2; i < visited.length; i++) {
			if (!visited[i]) {
				cnt += arr[i];
			}
		}
		System.out.println(cnt%2 == 0 ? "No" : "Yes");
	}
}
