package week8.ram;
import java.io.*;
import java.util.*;
/* 괄호(Parenthesis String)
 * 괄호의 쌍이 맞는지 검사
 */
public class BoJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            Stack<String> stack = new Stack();
            boolean isVPS = true;
            for (int j = 0; j < str.length(); j++) {
                String tmp = String.valueOf(str.charAt(j));

                
                if(tmp.equals("("))
                    stack.push(tmp);
                else if(tmp.equals(")")) {
                    if(!stack.empty()){
                        // stack에 여는 괄호가 존재한다면 stack의 값을 pop
                        stack.pop();
                    } else {
                        // 여는 괄호가 없는데 닫힌 괄호가 나왔으면 false
                        isVPS = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty())
                isVPS = false;

            if(isVPS)
                System.out.println("YES");
            else
                System.out.println("NO");
        }


    }
}
