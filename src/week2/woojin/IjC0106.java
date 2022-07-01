package week2.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    Site : Infrean Java Coding Site
    title : 중복 문자 제거
    number : 01강 06번
    subject : 문자열
 */

public class IjC0106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> list = new ArrayList<>();
        char[] input = br.readLine().toCharArray();

        for (char c : input) {
            if(!list.contains(c))
                list.add(c);
        }

        for (Character character : list) {
            System.out.print(character);
        }
        br.close();
    }

    /*
        indexOf가 해당 문자열이 나오는 첫 위치 index를 반환하는 것을 이용하여
        해당 "문자의 위치 = indexOf(문자)"인 경우만 출력
     */

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        for (int i = 0; i < input.length(); i++) {
//            if(input.indexOf(input.charAt(i)) == i){
//                System.out.print(input.charAt(i));
//            }
//        }
//        br.close();
//    }
}
