package week2.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/*
    Site : Infrean Java Coding Site
    title : 회문 문자열
    number : 01강 07번
    subject : 문자열
 */

public class IjC0107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase(Locale.ROOT);
        String reverse = new StringBuilder(input).reverse().toString();

        if(input.equals(reverse)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }

    /*
        toUpperCase() + equals() 대신 equalsIgnoreCase() 사용
        대소문자를 무시하고 비교하는 equalsIgnoreCase() 사용 방법
     */

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        String reverse = new StringBuilder(input).reverse().toString();
//
//        if(input.equalsIgnoreCase(reverse)){
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//        br.close();
//    }
}
