package week7.woojin;

/*
    Site : BOJ 백준 사이트
    title : 트리의 부모 찾기
    number : 1991
    subject : 트리, 이진 트리
    difficulty : silver 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoJ1991 {
    static class Node {
        private char val;
        private Node lN;
        private Node rN;

        public Node(char val) {
            this.val = val;
            this.lN = this.rN = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arrN = new Node[n];
        char start = 'A';
        for (int i = 0; i < n; i++) {
            arrN[i] = new Node(start++);
        }
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            // leaf Node 면 lN or rN null 값 세팅 그 외에는 입력 값으로 세팅
            arrN[input[0]-65].lN = input[2]=='.' ? null : arrN[input[2]-65];
            arrN[input[0]-65].rN = input[4]=='.' ? null : arrN[input[4]-65];
        }
        
        // 0부터 순회 시작
        preOrder(arrN[0]);
        System.out.println();
        inOrder(arrN[0]);
        System.out.println();
        postOrder(arrN[0]);
        br.close();
    }

    private static void postOrder(Node node) {
        if(node.lN != null)
            postOrder(node.lN);
        if(node.rN != null)
            postOrder(node.rN);
        System.out.print(node.val);
    }

    private static void inOrder(Node node) {
        if(node.lN != null)
            inOrder(node.lN);
        System.out.print(node.val);
        if(node.rN != null)
            inOrder(node.rN);
    }

    private static void preOrder(Node node) {
        System.out.print(node.val);
        if(node.lN != null)
            preOrder(node.lN);
        if(node.rN != null)
            preOrder(node.rN);
    }
}
