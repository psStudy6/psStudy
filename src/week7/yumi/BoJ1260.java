package week7.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/** 백준 1260 DFS와 BFS
 * 실버2
 * 
 * 문제 : 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 		단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
 * 		정점 번호는 1번부터 N번까지이다.
*/

// 21564 KB		408 ms
class Graph {
	class Node implements Comparable<Node> {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		Node(int data) {
			this.data = data;
			this.marked = false; // 방문여부
			adjacent = new LinkedList<Graph.Node>(); // 인접 리스트
		}

		@Override
		public int compareTo(Node node) {
			return this.data > node.data ? 1 : -1;
		}
		
	}
	
	Node[] nodes;
	
	public Graph(int size) {
		nodes = new Node[size + 1];
		for (int i = 1; i < size + 1; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	// 각 노드에 인접 노드 세팅
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	// 인접 리스트 정렬
	void sortNodes() {
		for (int i = 1; i < nodes.length; i++) {
			Collections.sort(nodes[i].adjacent);
		}
	}
	
	void initMarked() {
		for (int i = 1; i < nodes.length; i++) {
			nodes[i].marked = false;
		}
	}
	
	// DFS 재귀함수
	void dfsR(Node node) {
		if (node == null) {
			return;
		}
		node.marked = true;
		printNodes(node);
		for (Node adjacentNode : node.adjacent) {
			if (adjacentNode.marked == false) {
				dfsR(adjacentNode);
			}
		}
	}
	
	// DFS 재귀함수 호출
	void dfsR(int index) {
		Node node = nodes[index];
		sortNodes();
		dfsR(node);
	}
	
	// BFS 너비 우선 탐색
	void bfs(Queue<Node> queue) {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (Node adjacentNode : node.adjacent) {
				if (!adjacentNode.marked) {
					adjacentNode.marked = true;
					queue.add(adjacentNode);
				}
			}
			printNodes(node);
		}
	}
	
	// BFS 너비 우선 탐색 호출
	void bfs(int index) {
		Node root = nodes[index];
		initMarked();
		Queue<Node> queue = new LinkedList<Graph.Node>();
		// 루트 노드(탐색을 시작할 정점) 세팅
		queue.add(root);
		root.marked = true;
		sortNodes();
		bfs(queue);
	}
	
	// DFS 깊이 우선 탐색
	// - 틀린 이유 : 1개의 노드에 다른 모든 노드가 연결된 경우 stack에 이미 값을 넣은 상태이므로 순서가 맞지 않음
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		// 루트 노드(탐색을 시작할 정점) 세팅
		stack.push(root);
		root.marked = true;
		
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			Collections.sort(node.adjacent);
			for (Node adjacentNode : node.adjacent) {
				if (!adjacentNode.marked) {
					adjacentNode.marked = true;
					stack.push(adjacentNode);
				}
			}
			printNodes(node);
		}
	}
	
	// 출력
	void printNodes(Node node) {
		System.out.print(node.data + " ");
	}
}

public class BoJ1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());
		int root = Integer.parseInt(st.nextToken());
		Graph graph = new Graph(nodeCnt);
		
		while (edgeCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// DFS 깊이 우선 탐색
		graph.dfsR(root);
		System.out.println();
		// BFS 너비 우선 탐색
		graph.bfs(root);
	}
}
