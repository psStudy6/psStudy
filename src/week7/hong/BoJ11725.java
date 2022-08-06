/**
 * 등록 번호 : 11725번  
 * 등록 제목 : 트리의 부모 찾기
 * 현재 상태 : 실패 ❌
 */

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BoJ11725 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static ArrayList<Integer>[] graph;
	static int[] parents;

	public static void main(String[] args) throws IOException {
	
		N = Integer.parseInt(br.readLine());
		
		// 부모를 저장할 배열, 각 인덱스의 값이 부모
		parents = new int[N + 1];
		graph = new ArrayList[N + 1];

		for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
		for(int i=1; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		solution();
	}

	public static void solution() {
		DFS(1, -1);
		for(int i=2; i<=N; i++) sb.append(parents[i]).append('\n');
		System.out.println(sb.toString()); 
	}

	public static void DFS(int x, int parent) {
		// x와 연결된 간선을 확인
		for(int y : graph[x]) {
			// 부모 노드 제외
			if(y == parent) continue;
			parents[y] = x;
      // 재귀함수
			DFS(y, x); 
		}
	}

}
