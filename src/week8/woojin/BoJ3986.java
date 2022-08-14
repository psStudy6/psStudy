package week8.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    Site : BOJ 백준 사이트
    title : 좋은 단어
    number : 3986
    subject : stack
    difficulty : silver 4
 */

public class BoJ3986 {
    // 처음에 삽질을 좀 함
    //i와 i+2가 같으면 좋은 단어가 안되고 다르면 되는 줄 알고 문자열 비교로 진행하려 했지만 실패
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        while(n -- > 0){
            Stack<String> s = new Stack<>();
            String[] input = br.readLine().split("");
            for (String value : input) {
                if (s.isEmpty())
                    s.push(value);
                else {
                    if (s.peek().equals(value)) {
                        s.pop();
                    } else {
                        s.push(value);
                    }
                }
            }
            if(s.isEmpty())
                result++;
        }
        System.out.println(result);
        br.close();
    }
}
