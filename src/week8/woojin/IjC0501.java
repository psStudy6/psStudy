package week8.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    Site : Infrean Java Coding Site
    title : 올바른 괄호
    number : 05강 01번
    subject : Stack
    my velog link :
 */

public class IjC0501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> s = new Stack<>();
        String[] input = br.readLine().split("");
        for (int i = 0; i < input.length; i++) {
            if(input[i].equals("(")){
                s.push(input[i]);
            } else{
                if(s.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                s.pop();
            }
        }
        if (s.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }
}
