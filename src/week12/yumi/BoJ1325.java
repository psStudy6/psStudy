package week12.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

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

public class BoJ1325 {
	public static void main(String[] args) throws IOException{
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
		List<Integer> li = new ArrayList<>();
		for (int i = 1; i < args.length; i++) {
			int cnt = graph.dfs(i);
			if(max >  cnt) {
				continue;
			}
			if (max < cnt) {
				li.clear();
			}
			li.add(i);
		}
		System.out.println();
	}
}
