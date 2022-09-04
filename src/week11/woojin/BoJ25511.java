package week11.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    Site : BOJ 백준 사이트
    title : 값이 k인 트리 노드의 깊이
    number : 25511
    subject : dfs
    difficulty : silver 2
    velog : https://velog.io/@dnwlsrla40/DFS-%EA%B0%92%EC%9D%B4-k%EC%9D%B8-%ED%8A%B8%EB%A6%AC-%EB%85%B8%EB%93%9C%EC%9D%98-%EA%B9%8A%EC%9D%B4
 */

public class BoJ25511 {
    static class Node{
        private int index;
        private int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        ArrayList[] list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            list[Integer.parseInt(input[0])].add(new Node(Integer.parseInt(input[1]), 0));
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {

        }
    }
}
