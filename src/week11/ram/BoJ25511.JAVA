package week11.ram;
/* 값이 k인 트리 노드의 깊이
 * 가중치가 없는 트리
 * 
 */
import java.util.*;

import week11.ram.IjC707.Node;

import java.io.*;
public class BoJ25511 {
	static class Node{
		int data;
		Node lt,rt;
		public Node(int val) {
			data=val;
			lt=rt=null;
		}
	}
	public static int bfs(ArrayList<ArrayList<Integer>> Q) {
		//Queue<Node> Q =new LinkedList<>();
		//Q.add(root);
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
			//System.out.println();
		}
		return L;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		/* 인접리스트 */
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[] parents=new int[n+1];
		for(int i=0;i<=n+1;i++)list.add(new ArrayList<Integer>());
		
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		int start = 1;
		bfs(start,list,parents,n);
	}

}
