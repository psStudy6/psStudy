package week7.ram;
import java.util.*;
import java.io.*;
/* 트리 순회
 * 이진트리 : 모든 노드가 2개이하의 자식 수를 가지고 있다(차수가 2 이하)
 * 마지막 레벨에서 노드가 꽉 차있지 않아도 된다.
 * 전위 순회 & 중위 순회 & 후위 순회
 */
public class BoJ1991 {
	static class Node {
		char ch;
		Node right;
		Node left;
		
		public Node(char ch) { //노드 생성자 : 객체가 생성될 때마다 data를 초기화
			this.ch = ch;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //노드의 개수
		Node[] arr = new Node[T];
		for(int i=0;i<T;i++) {
			arr[i] = new Node((char) (i + 'A')); //arr[0] = 'A'로 채워짐
		}
		
		/* 자식 정보를 입력하는 반복문 */
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N =st.nextToken().charAt(0)-'A';
			//System.out.print(N+" ");
			int L = st.nextToken().charAt(0)-'A';
			int R = st.nextToken().charAt(0)-'A';
			
			if(L != -19) arr[N].left = arr[L];//N이 1일 경우 L은 3이고, R은 .(-19) 그러면 arr[1].right은 공백
			if(R != -19) arr[N].right = arr[R];
			
			
		}
		preorder(arr[0]);
		sb.append('\n');
		inorder(arr[0]);
		sb.append('\n');
		postorder(arr[0]);
		sb.append('\n');
		System.out.println(sb.toString());
		
		
		
	}
	public static void preorder(Node node) {
		sb.append(node.ch);
		if(node.left != null) preorder(node.left);
		if(node.right != null) preorder(node.right);
	}
	
	public static void inorder(Node node) {
		if(node.left != null) inorder(node.left);
		sb.append(node.ch);
		if(node.right != null) inorder(node.right);
	}
	/* 후위 순회 : 왼쪽자식 -> 오른쪽 자식 -> 루트 */
	public static void postorder(Node node) {
		if(node.left != null) postorder(node.left);
		if(node.right != null) postorder(node.right);
		sb.append(node.ch);
	}
	

}
