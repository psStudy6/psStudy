package week7.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/** 백준 11725 트리의 부모 찾기
 * 실버2
 * 
 * 문제 : 루트 없는 트리가 주어진다. 
 * 		 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램
 * 
 * 핵심 : 이진트리가 아닌 일반 그래프임
 * 		입력 순서는 루트, 기존 노드와 이어진 노드들이 아닌 무작위임
 * 		정답 코드 : BoJ11725.java
 * 		
 * 
 * 틀린 이유 : 예시만 보고 이진트리라 생각함
 * 			예시만 보고  첫 번째 입력에 루트 노드와 자식 노드가 오고, 그 다음도 기존에 입력된 노드와 이어진 노드가 올거라 생각함
 * 			-> 예시는 통과하지만 실제 돌려보이면 런타임 에러 (NullPointer) 발생
*/

class Tree2 {
	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	HashMap<Integer, Node> rootMap;
	
	public Tree2(int rootData) {
		root = new Node(rootData); 
		rootMap = new HashMap<Integer, Tree2.Node>();
		rootMap.put(rootData, root);
	}

	public void makeNode(int data1, int data2) {
		int parent = rootMap.containsKey(data1) ? data1 : data2;
		int child = rootMap.containsKey(data1) ? data2 : data1;
		makeChildNode(rootMap.get(parent), parent, child);
	}
	
	private void makeChildNode(Node node, int parent, int child) {
		Node childNode = new Node(child);
		if (node.left == null) {
			node.left = childNode;
		} else {
			node.right = childNode;
		}
		childNode.parent = node;
		rootMap.put(child, childNode);
	}
	
	public void printParentNode() {
		StringBuffer sb = new StringBuffer();
		for (int i = 2; i <= rootMap.size(); i++) {
			sb.append(rootMap.get(i).parent.data).append("\n");
		}
		System.out.println(sb);
	}
}

public class BoJ11725_F {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tree2 tree = new Tree2(1);
		
		while (n-- > 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.makeNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		tree.printParentNode();
	}
}
