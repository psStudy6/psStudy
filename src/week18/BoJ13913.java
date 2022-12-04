package week18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 13913 숨박꼭질4
 */
public class BoJ13913 {
    public static final int MAX = 1000000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈 위치
        int k = sc.nextInt(); // 동생 위치
        solution(n, k);
        System.out.println();
    }

    private static void solution(int n, int k) {
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] from = new int[MAX]; // 이전 위치

        check[n] = true;
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.remove();
            // 걷기 뒤
            if (now - 1 >= 0 && check[now-1] == false) {
                q.add(now-1);
                check[now-1] = true;
                dist[now-1] = dist[now] + 1; // 시간
                from[now-1] = now; // 이전 위치
            }
            // 걷기 앞
            if (now + 1 < MAX && check[now+1] == false) {
                q.add(now+1);
                check[now+1] = true;
                dist[now+1] = dist[now] + 1;
                from[now+1] = now;
            }
            // 순간 이동
            if (now * 2 < MAX && check[now*2] == false) {
                q.add(now*2);
                check[now*2] = true;
                dist[now*2] = dist[now] + 1;
                from[now*2] = now;
            }
        }
        // 수빈이가 동생을 찾는 가장 빠른 시간
        System.out.println(dist[k]);
        // 어떻게 이동해야 하는지 공백으로 구분
        print(from, n, k);
    }

    static void print(int[] from, int n, int k) {
        if (n != k) {
            print(from, n, from[k]);
        }
        System.out.print(k + " ");
    }

    private static void print2(int n, int k, int[] from) {
        Stack<Integer> ans = new Stack<>();
        for (int i = k; i!= n; i= from[i]) {
            ans.push(i);
        }
        ans.push(n);
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
    }
}
