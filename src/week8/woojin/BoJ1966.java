package week8.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
    Site : BOJ 백준 사이트
    title : 프린터 큐
    number : 11725
    subject : 큐
    difficulty : silver 3
 */

public class BoJ1966 {
    static class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int count = 0;
            Queue<Node> q = new LinkedList<>();
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            Node target = new Node(m, 0);
            for (int i = 0; i < n; i++) {
                q.add(new Node(i, Integer.parseInt(input[i])));
                if(i == m){
                    target.val = Integer.parseInt(input[i]);
                }
            }

            while (!q.isEmpty()) {
                Node temp = q.poll();
                count++;
                boolean flag = false;
                for (Node node : q) {
                    if(temp.val < node.val){
                        flag = true;
                        q.add(temp);
                        count--;
                        break;
                    }
                }
                if(!flag && temp.index == target.index && temp.val == target.val) {
                    System.out.println(count);
                    break;
                }
            }
        }
        br.close();
    }
}
