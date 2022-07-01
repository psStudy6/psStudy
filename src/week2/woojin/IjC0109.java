package week2.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : Infrean Java Coding Site
    title : 숫자만 추출
    number : 01강 09번
    subject : 문자열
 */

public class IjC0109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        String answer = "";
        for (char c : input) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        System.out.println(Integer.parseInt(answer));
    }

    /*
        아스키코드 값을 통해서 0~9까지의 값을 구분
        맨 앞의 0을 확인하면서 자리 수를 증가시켜 주기 위해
        `answer = answer * 10`을 이용했다.
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] input = br.readLine().toCharArray();
//        int answer = 0;
//        for (char c : input) {
//            if(48<=c && c<= 57){
//                answer = answer * 10 + (c - 48);
//            }
//        }
//        System.out.println(answer);
//    }
}
