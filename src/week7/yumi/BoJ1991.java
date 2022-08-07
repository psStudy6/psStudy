package week7.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 1991 트리순회
 * 실버1
 * 
 * 문제 : 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 * 		각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
 * 		노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다.
 * 		전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
 * 		중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
 * 		후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
 * 
 * 핵심 : Node, Tree 객체 생성
 * 		Node : 입력이 노드, 왼쪽 자식 노드, 오른쪽 자식 노드로 주어지므로 자식 노드의 자식 노드는 알 수 없음
 * 			   생성자에는 char 데이터(노드)만 세팅후 자식노드는 Node로 세팅
 * 		Tree : 루트 노드 먼저 세팅 후 새로운 입력값이 들어오면 루트부터 탐색
 * 				입력된 노드를 찾으면 자식 노드 세팅
*/

class Node {
	char data;
	Node left;
	Node right;
	
	public Node(char data) {
		this.data = data;
	}
}

class Tree {
	public Node root;
	
	public Node getRoot() {
		return root;
	}

	private void setRoot(Node root) {
		this.root = root;
	}
		
	public void makeNode(char data, char left, char right) {
		// 입력 조건 : 노드의 이름은 A부터 차례대로, 항상 A가 루트 노드
		// 첫 번째 입력이 루트이므로 root가 널일 시 루트노드의 데이터 세팅
		if (root == null) {
			setRoot(new Node(data));
		} 
		// 노드 탐색
		searchNode(root, data, left, right);
	}
	
	private void searchNode(Node node, char data, char left, char right) {
		// 노드가 없을 시 탐색 종료 (이전 노드 = 리프노드)
		if (node == null) {
			return;
		}
		// 입력된 노드가 이미 존재하는 경우 (이전 입력에서 자식 노드로 존재함 = 리프노드)
		// - 입력값으로 노드 세팅 (부모노드 또는 리프노드) 
		if (node.data == data) {
			node.left = left == '.' ? null : new Node(left);
			node.right = right == '.' ? null : new Node(right);
		} else {
			// 입력 노드가 나올 때까지 트리 탐색
			searchNode(node.left, data, left, right);
			searchNode(node.right, data, left, right);
		}
	}
	
	// 전위 순회(preorder traversal) - (루트) (왼쪽 자식) (오른쪽 자식)
	public void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	// 중위 순회(inorder traversal) - (왼쪽 자식) (루트) (오른쪽 자식)
	public void inorder(Node node) {
		if (node != null) {
			
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}
	
	// 후위 순회(postorder traversal) - (왼쪽 자식) (오른쪽 자식) (루트)
	public void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}
}

public class BoJ1991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.makeNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		br.close();
		Node rootNode = tree.getRoot();
		// 전위 순회
		tree.preorder(rootNode);
		System.out.println();
		// 중위 순회
		tree.inorder(rootNode);
		System.out.println();
		// 후위 순회
		tree.postorder(rootNode);
	}
}
