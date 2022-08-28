package week10.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 백준 9934 완전 이진 트리 - 틀림
 * 실버 1
 * 
 * 문제 : 이 도시의 도로는 깊이가 K인 완전 이진 트리를 이루고 있다. 
 * 		깊이가 K인 완전 이진 트리는 총 2K-1개의 노드로 이루어져 있다. 
 * 		각 노드에는 그 곳에 위치한 빌딩의 번호가 붙여져 있다. 
 * 		또, 가장 마지막 레벨을 제외한 모든 집은 왼쪽 자식과 오른쪽 자식을 갖는다.
 * 		중위 순회(inorder traversal) - (왼쪽 자식) (루트) (오른쪽 자식) 방식으로 건물을 들린다.
 * 		상근이가 종이에 적은 순서가 모두 주어졌을 때, 각 레벨에 있는 빌딩의 번호를 구하는 프로그램
 * 
 * 핵심 : 중위 순회(inorder traversal) - (왼쪽 자식) (루트) (오른쪽 자식)
 * 
 * 
 * 
 * 틀린 이유 및 문제점 : 
 * 
 * 
*/
public class BoJ9934_F {
	static int depth;
	static int[] arr;
	static List<List<Integer>> list;
	
	// 루트 기준 왼쪽 트리와 오른쪽 트리의 제일 왼쪽 리프노드 
	public void leftLeatNode(int n, int i) {
		list.get(n).add(arr[i]);
		parentNode(n-1, i+1);
	}
	
	public void parentNode(int n, int i) {
		if (i == arr.length) {
			return;
		}
		// 본인 노드
		list.get(n).add(arr[i]);
				
		if (n == 1) {
			leftLeatNode(depth, ++i);
			return;
		}
		// 오른쪽 자식 노드
		list.get(n+1).add(arr[++i]);
		parentNode(n-1, ++i);
	}
	
	public static void main(String[] args) throws IOException {
		BoJ9934_F boj = new BoJ9934_F();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		depth = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 방문한 도시 배열
		arr = new int[st.countTokens()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// list 세팅
		list = new ArrayList<List<Integer>>();
		for (int i = 0; i <= depth; i++) {
			list.add(new ArrayList<>());
		}
		br.close();
		
		// 트리 탐색
		boj.leftLeatNode(depth, 0);
		
		// 출력
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= depth; i++) {
			List<Integer> li = list.get(i);
			for (Integer num : li) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
