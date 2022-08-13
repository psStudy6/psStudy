package week8.ram;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//공주 구하기
public class IjC506 {

    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        	
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int num = queue.poll();

            if (count == k) {
                count = 1;
            } else {
                queue.offer(num);
                count++;
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));

        sc.close();
    }
}