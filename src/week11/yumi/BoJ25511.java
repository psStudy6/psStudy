package week11.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 25511 값이 k인 트리 노드의 깊이
 * 실버2
 * 
 * 문제 : n개의 정점과 n - 1개의 간선으로 구성된 트리 T가 있다. 
 * 		정점 번호는 0부터 n - 1까지이고 0번 정점이 루트이다.
 * 		간선에는 가중치가 없다. 트리 T에 있는 각 정점에는 서로 다른 값이 부여된다. 
 * 		트리 T에서 정점에 부여된 값이 k인 노드의 깊이(depth)를 출력하자.
 * 		-> 특정 정점(k)의 깊이 출력
*/
class Node {
	int idx;
	int depth;
	int data;
	Node left;
	Node right;
	
	public Node(int idx, int depth) {
		this.idx = idx;
		this.depth = depth;
	}
}

class Tree {
	Node root;
	Node kNode;
	int k;
	
	public Tree(int k) {
		this.k = k;
	}

	private void setRoot(Node root) {
		this.root = root;
	}
	
	public void makeNode(int idx, int child) {
		if (root == null) {
			setRoot(new Node(idx, 0));
		}
		searchNode(root, idx, child, root.depth + 1);
	}

	private void searchNode(Node node, int idx, int child, int depth) {
		if (node == null) {
			return;
		}
		if (node.idx == idx) {
			if (node.left == null) {
				node.left = new Node(child, depth);
			} else {
				node.right = new Node(child, depth);
			}
		} else {
			searchNode(node.left, idx, child, depth + 1);
			searchNode(node.right, idx, child, depth + 1);
		}
	}
	
	public void setNodesData(String[] arr) {
		searchNodeIdx(root, arr);
	}
	
	private void searchNodeIdx(Node node, String[] arr) {
		if (node == null) {
			return;
		}
		node.data = Integer.parseInt(arr[node.idx]);
		if (node.data == k) {
			kNode = node;
		}
		searchNodeIdx(node.left, arr);
		searchNodeIdx(node.right, arr);
	}
}
public class BoJ25511 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Tree tree = new Tree(k);
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			tree.makeNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		String[] arr = br.readLine().split(" ");
		tree.setNodesData(arr);
		System.out.println(tree.kNode.depth);
	}
}
