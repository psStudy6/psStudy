package week2.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : Infrean Java Coding Site
    title : 특정 문자 뒤집기
    number : 01강 05번
    subject : 문자열
 */

public class IjC0105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int lt = 0, rt = input.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(input[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(input[rt])) {
                rt--;
            } else {
                char temp = input[lt];
                input[lt] = input[rt];
                input[rt] = temp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(input));
        br.close();
    }
}
