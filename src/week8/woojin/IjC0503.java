package week8.woojin;

/*
    Site : Infrean Java Coding Site
    title : 크레인 인형뽑기
    number : 05강 03번
    subject : Stack
    my velog link :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IjC0503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Queue<Integer>[] qArr = new Queue[n+1];
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < n+1; i++) {
            qArr[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < n+1; j++) {
                if(Integer.parseInt(input[j-1]) != 0)
                    qArr[j].add(Integer.parseInt(input[j-1]));
            }
        }
        int m = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int crane = Integer.parseInt(input[i]);
            if(!qArr[crane].isEmpty()){
                int doll = qArr[crane].poll();
                if(!s.isEmpty() && s.peek() == doll) {
                    count += 2;
                    s.pop();
                } else {
                    s.push(doll);
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
