package week12.ram;
import java.util.*;


import java.io.*;
/* 트리 말단 노드까지의 가장 짧은 경로
 * 주어진 이진트리의 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은
 * 길이(간선의 개수가 적은 개수)를 구하는 문제
 * 
 */
public class IjC709 {
	static class Node{
		int data;
		Node left,right;
		public Node(int val) {
			data=val;
			left=right=null;
		}
	}
	public static int bfs(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int level = 0;//트리의 현재 레벨 = 간선의 개수
		
		while(!q.isEmpty()) {
			int len = q.size();
			//System.out.println(len);
			for(int i=0;i<len;i++) {
				Node node = q.poll();
				
				//자식노드가 없다는 건 말단 노드
				if(node.left==null&&node.right==null)
					return level;
				if(node.left !=null)
					q.offer(node.left);
				if(node.right != null)
					q.offer(node.right);
			}
			level++;
			
		}
		return -1;
	}
	public static int dfs(int L,Node root) {
	//	System.out.println(L);
		if(root.left==null&&root.right==null) return L;
		else return Math.min(dfs(L+1,root.left), dfs(L+1,root.right));
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right = new Node(3);
		root.right.left=new Node(7);
		root.right.right=new Node(9);
		System.out.println(dfs(0,root));
	}

}
