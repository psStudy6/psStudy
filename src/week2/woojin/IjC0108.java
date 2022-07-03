package week2.woojin;

/*
    Site : Infrean Java Coding Site
    title : 유효한 팰린드롬
    number : 01강 08번
    subject : 문자열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class IjC0108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
        String reverse = new StringBuilder(input).reverse().toString();
        if(reverse.equals(input))
            System.out.println("YES");
        else
            System.out.println("NO");
        br.close();
    }
}
