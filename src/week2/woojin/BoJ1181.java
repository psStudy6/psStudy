package week2.woojin;

/*
    Site : BOJ 백준 사이트
    title : 단어 정렬
    number : 1181
    subject : 문자열
 */

import java.io.*;

public class BoJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(word[i].length() > word[j].length()){
                    String temp = word[i];
                    word[i] = word[j];
                    word[j] = temp;
                } else if(word[i].length() == word[j].length()) {
                    if(word[i].compareTo(word[j]) > 0) {
                        String temp = word[i];
                        word[i] = word[j];
                        word[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(i != n-1 && word[i].equals(word[i+1]))
                continue;
            System.out.println(word[i]);
        }

    }
}
