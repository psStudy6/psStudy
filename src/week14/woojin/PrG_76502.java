package week14.woojin;

import java.util.Stack;

public class PrG_76502 {
    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='(' || s.charAt(j)=='{' || s.charAt(j)=='['){
                    stack.push(s.charAt(j));
                } else {
                    if(!stack.isEmpty()) {
                        char c = stack.pop();
                        if(c=='(' && !(s.charAt(j) == ')')){
                            flag = true;
                            break;
                        } else if(c=='{' && !(s.charAt(j)=='}')){
                            flag = true;
                            break;
                        } else if(c=='[' && !(s.charAt(j)==']')){
                            flag = true;
                            break;
                        }
                    }else {
                        flag = true;
                        break;
                    }
                }
            }
            if(!stack.isEmpty())
                flag = true;
            if(!flag)
                answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
}
