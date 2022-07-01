package week2.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    Site : BOJ 백준 사이트
    title : 버그왕
    number : 3447
    subject : 문자열
 */

public class BoJ3447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null){
            while(input.contains("BUG")) {
                input = input.replace("BUG", "");
            }
            System.out.println(input);
        }
        br.close();
    }
}
