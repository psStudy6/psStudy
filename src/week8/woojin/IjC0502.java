package week8.woojin;

/*
    Site : Infrean Java Coding Site
    title : 괄호문자제거
    number : 05강 02번
    subject : Stack
    my velog link :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IjC0502 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] input = br.readLine().toCharArray();
//        Stack<Character> s = new Stack<>();
//        for (int i = 0; i < input.length; i++) {
//            if(input[i] == '(')
//                s.push(input[i]);
//            else if(input[i] == ')')
//                s.pop();
//            else {
//                if(s.isEmpty())
//                    System.out.print(input[i]);
//            }
//        }
//        br.close();
//    }

        // pop이 원소를 return 하는 것을 이용하여
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char[] input = br.readLine().toCharArray();
            Stack<Character> s = new Stack<>();
            for (int i = 0; i < input.length; i++) {
                if(input[i] == ')')
                    while(s.pop() != '(');
                else
                    s.push(input[i]);
            }
            for (Character character : s) {
                System.out.print(character);
            }
            br.close();
        }
}
