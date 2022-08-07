package week7.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/** 백준 11725 트리의 부모 찾기
 * 실버2
 * 
 * 문제 : 루트 없는 트리가 주어진다. 
 * 		 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램
 * 
 * 핵심 : 이진트리가 아닌 일반 그래프임
 * 		입력 순서는 루트, 기존 노드와 이어진 노드들이 아닌 무작위임
 * 		
 * 
 * 틀린 코드 : BoJ11725_F.java
 * 틀린 이유 : 예시만 보고 이진트리라 생각함
 * 			예시만 보고  첫 번째 입력에 루트 노드와 자식 노드가 오고, 그 다음도 기존에 입력된 노드와 이어진 노드가 올거라 생각함
 * 			-> 예시는 통과하지만 실제 돌려보이면 런타임 에러 (NullPointer) 발생
*/

public class BoJ11725 {
	
	// 방법 1 : BFS 너비 우선 탐색
	// 59864 KB		620 ms
	public int[] solution(List<Integer>[] list, int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+1];
		int[] parent = new int[n+1]; 
		// 루트 1 세팅
		queue.add(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int parentNode = queue.poll();
			// 탐색하지 않은 자식 노드 탐색
			for (int childNode : list[parentNode]) {
				if (!visited[childNode]) {
					visited[childNode] = true;
					parent[childNode] = parentNode;
					queue.add(childNode);
				}
			}
		}
		return parent;
	}
	
	// 방법2 : DFS 깊이 우선 탐색 & 재귀함수
	// 67784 KB		612 ms
	public void dfs(List<Integer>[] list, int[] parent, int node, int parentNode) {
		parent[node] = parentNode;
		for (int childNode : list[node]) {
			if (childNode != parentNode) {
				dfs(list, parent, childNode, node);
			}
		}
	}
	public int[] solution2(List<Integer> list[], int n) {
		int[] parent = new int[n+1];
		dfs(list, parent, 1, 0); // 루트 노드 세팅
		return parent;
	}
 	
	// 출력
	public void printParent(int[] parent) {
		StringBuffer sb = new StringBuffer();
		for (int i = 2; i < parent.length; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		BoJ11725 boj = new BoJ11725();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList [n+1]; // 인접 리스트
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		//int[] parent = boj.solution(list, n);
		int[] parent = boj.solution2(list, n);
		boj.printParent(parent);
 	}
}
