package week2.woojin;

/*
    Site : BOJ 백준 사이트
    title : 가장 많은 글자
    number : 1371
    subject : 문자열
 */

import java.io.*;
import java.util.Scanner;

public class BoJ1371 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        StringBuilder answer = new StringBuilder();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char target = line.charAt(i);
                if(target != ' ') {
                    count[target-'a']++;
                    if(max < count[target-'a'])
                        max = count[target-'a'];
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if(max == count[i])
                answer.append((char) (i + 97));
        }

        bw.write(answer.toString());
        bw.close();

//        Scanner sc = new Scanner(System.in);
//        String temp;
//        String input = "";
//        StringBuilder answer = new StringBuilder();
//        int max = Integer.MIN_VALUE;
//        while (sc.hasNextLine()){
//            temp = sc.nextLine();
//            input += temp;
//        }
//
//        for (char i = 97; i < 123; i++) {
//            int count = input.length() - input.replace(String.valueOf(i), "").length();
//            if(max < count){
//                max = count;
//                answer.setLength(0);
//                answer.append(i);
//            } else if(max == count){
//                answer.append(i);
//            }
//        }
//        System.out.println(answer);
    }
}
