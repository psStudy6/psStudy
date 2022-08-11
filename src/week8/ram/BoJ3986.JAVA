import java.util.*;
import java.io.*;
public class BoJ3986 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        count = 0;
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            goodWordCheck(s);
        }
        System.out.print(count);
    }

    static void goodWordCheck(String s) {
        if (s.length() % 2 == 1) return; //문자열의 길이가 홀수이다는 것은 A 또는 B의 개수가 홀수이므로 좋은단어 X
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0)); //첫 단어는 스택에 push
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) count++;
    }
}
