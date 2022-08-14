package week8.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    Site : BOJ 백준 사이트
    title : 괄호
    number : 9012
    subject : 스택
    difficulty : silver 4
 */

public class BoJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Stack<String> s = new Stack<>();
            String[] input = br.readLine().split("");
            boolean flag = false;
            for (int j = 0; j < input.length; j++) {
                if(input[j].equals("("))
                    s.push(input[j]);
                else {
                    if(s.isEmpty()) {
                        flag = true;
                        System.out.println("NO");
                        break;
                    }
                    s.pop();
                }
            }
            if(!s.isEmpty())
                System.out.println("NO");
            else if(!flag)
                System.out.println("YES");
        }
    }
}
