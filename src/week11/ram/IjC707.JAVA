package week11.ram;
import java.util.*;
import java.io.*;

public class IjC707 {
	static class Node{
		int data;
		Node lt,rt;
		public Node(int val) {
			data=val;
			lt=rt=null;
		}
	}
	public static void bfs(Node root) {
		Queue<Node> Q =new LinkedList<>();
		Q.add(root);
		int L = 0;
		//루트 노드의 레벨은 0
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L+" : ");
			//해당 레벨의 원소들 모두 출력
			for(int i=0;i<len;i++) {
				Node cur = Q.poll();
				System.out.print(cur.data+" ");
				if(cur.lt!=null) Q.add(cur.lt);
				if(cur.rt!=null) Q.add(cur.rt);
			}
			L++;//레벨 증가
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.lt=new Node(2);
		root.rt=new Node(3);
		root.lt.lt=new Node(4);
		root.lt.rt=new Node(5);
		root.rt.lt=new Node(6);
		root.rt.rt=new Node(7);
		bfs(root);
	}

}
