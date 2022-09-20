package week12.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


/** 백준 1325 효율적인 해킹
 * 
 * 문제 : 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다
 * 		회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력
 * 
 * 핵심 : 객체보단 인접행렬/인접리스트 & bfs 활용
 * 		주의) A가 B를 신뢰하면 B 해킹 시 A도 해킹 가능
 * 		-> A기준 인접행렬/인접리스트 생성 후 탐색 시 B의 카운트 증가시킴
 * 
 * 틀린 이유 : B를 기준으로 BFS 탐색함
*/

public class BoJ1325 {
	
	public static int n;
	public static List<Integer>[] arr;
    public static int[] cntArr;
	
    // 방법 1 : 인접행렬/인접리스트, A를 기준으로 bfs 탐색 & 탐색 시 B의 카운트 증가 - 성공
	public String solution() {
		StringBuffer sb = new StringBuffer();
		int max = Integer.MIN_VALUE;
		cntArr = new int[n+1];
		// 컴퓨터별로 bfs 탐색 - A 기준
		for (int i = 1; i < arr.length; i++) {
            search(i);
		}
		// max 값 구함 - B 기준
        for (int i = 1; i < cntArr.length; i++) {
			max = Math.max(max, cntArr[i]);
		}
        // max 값에 해당하는 컴퓨터 모두 출력
		for (int i = 1; i < cntArr.length; i++) {
			if (cntArr[i] == max) {
				sb.append(i).append(" ");
			}
		}
		return sb.toString().trim();
	}
	
	// BFS
	public void search(int stt) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visisted = new boolean[n+1];
		queue.add(stt);
        visisted[stt] = true;
        // A가 신뢰하는 모든 컴퓨터(B) 탐색
		while (!queue.isEmpty()) {
			int computer = queue.poll();
			for (int comIdx : arr[computer]) {
				if (!visisted[comIdx]) {
					queue.add(comIdx);
					visisted[comIdx] = true;
					// B를 통해 해킹 가능한 컴퓨터 개수++
					// -> A가 B를 신뢰하면 B 해킹 시 A도 해킹 가능
					cntArr[comIdx]++;
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BoJ1325 boj = new BoJ1325();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		// 인접행렬 세팅
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		// 입력값 세팅
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int stt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// A 기준 (A가 B를 신뢰)
			arr[stt].add(end);
		}
		System.out.println(boj.solution());
	}

	
	
	
	
	
	
	
	
	
	
	// 시간초과로 실패 로직--------------------------------------------------------------------------------------------------------
	// 방법 2 : 인접리스트 사용, B에 연결된 A를 기준으로 bfs 탐색 - 시간 초과로 실패
	public static ArrayList<ArrayList<Integer>> list;
	
	public String solution2() {
		StringBuffer sb = new StringBuffer();
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < list.size(); i++) {
			int cnt = search2(i);
			max = Math.max(max, cnt);
			if (cnt < max) {
				continue;
			}
			if (cnt > max) {
				sb.delete(0, sb.length());
				max = cnt;
			}
			sb.append(i).append(" ");
		}
		for (int i = 1; i < cntArr.length; i++) {
			if (cntArr[i] == max) {
				sb.append(i).append(" ");
			}
		}
		return sb.toString();
	}
	
	public int search2(int stt) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visisted = new boolean[n+1];
		int cnt = 0;
		queue.add(stt);
		visisted[stt] = true;
		while (!queue.isEmpty()) {
			int computer = queue.poll();
			for (int comIdx : list.get(computer)) {
				if (!visisted[comIdx]) {
					queue.add(comIdx);
				}
			}
			cnt++;
		}
		return cnt;
	}
	
	
	public static void main2(String[] args) throws IOException{
		BoJ1325 boj = new BoJ1325();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int stt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// B기준
			list.get(end).add(stt);
		}
		System.out.println(boj.solution2());
	} 
	
	
	
	
	
	// 시간초과로 실패 로직--------------------------------------------------------------------------------------------------------
	// 방법 3 : Graph 객체 사용 - 시간 초과로 실패
	public static void main3(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Graph graph = new Graph(n+1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int max = Integer.MIN_VALUE;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < n; i++) {
			int cnt = graph.dfs(i);
			graph.clearMark();
			if(max >  cnt) {
				continue;
			}
			if (max < cnt) {
				max = cnt;
				sb = new StringBuffer();
			}
			sb.append(i).append(" ");
		}
		br.close();
		System.out.println(sb.toString());
	}
}

// 방법 2 : Graph 객체 사용 - 시간 초과로 실패
class Graph {
    class Node {
        int data;
        LinkedList<Node> adj;
        boolean mark;
        
        Node(int data) {
            this.data = data;
            this.mark = false;
            adj = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    
    Graph(int size) {
    	nodes = new Node[size];
    	for(int i=1; i<size;i++){
    	    nodes[i] = new Node(i);
    	}    
    }
    
    void addEdge(int i1, int i2) {
        Node node1 = nodes[i1];
        Node node2 = nodes[i2];
        if(!node2.adj.contains(node1)) {
            node2.adj.add(node1);
        }
    }
    
    void clearMark() {
    	for (int i = 1; i < nodes.length; i++) {
			nodes[i].mark = false;
		}
    }
    
    int dfs(int idx) {
    	Node root = nodes[idx];
    	Stack<Node> st = new Stack<Node>();
    	st.push(root);
    	root.mark = true;
    	int cnt = 0;
    	while(!st.isEmpty()) {
    	    Node node = st.pop();
    	    for(Node n : node.adj) {
    	        if(!n.mark) {
    	            n.mark = true;
    	            st.push(n);
     	        }     	     
    	    }
    	    cnt++;
    	}
    	return cnt;
    }
}