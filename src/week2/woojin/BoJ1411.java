package week2.woojin;

/*
    Site : BOJ 백준 사이트
    title : 비슷한 단어
    number : 1411
    subject : 문자열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoJ1411 {
    /*
       처음에 하나의 mapping 배열로 처리하려고 했는데
       그럴경우 cacccdaabc 와 dcdddbccad 같은 옳게 변환된 경우도 false로 반환
     */
//    public static boolean check(int i, int j, String[] words) {
//        char[] mapping = new char[26];
//
//        for (int k = 0; k < words[i].length(); k++) {
//            if(mapping[words[i].charAt(k)-'a'] == '\u0000' && mapping[words[j].charAt(k)-'a'] == '\u0000') {
//                mapping[words[i].charAt(k) - 'a'] = words[j].charAt(k);
//                mapping[words[j].charAt(k) - 'a'] = words[i].charAt(k);
//            } else if(mapping[words[j].charAt(k) - 'a'] != words[i].charAt(k) || mapping[words[i].charAt(k) - 'a'] != words[j].charAt(k))
//                return false;
//        }
//        return true;
//    }
    
    /*
        그래서 아래와 같이 2개의 mapping 배열을 이용해서 따로따로 확인
     */
    public static boolean check(int i, int j, String[] words) {
        char[] mapping1 = new char[26];
        char[] mapping2 = new char[26];
        for (int k = 0; k < words[i].length(); k++) {
            if (mapping1[words[j].charAt(k) - 'a'] == '\u0000' && mapping2[words[i].charAt(k) - 'a'] == '\u0000') {
                mapping1[words[j].charAt(k) - 'a'] = words[i].charAt(k);
                mapping2[words[i].charAt(k) - 'a'] = words[j].charAt(k);
            } else if(mapping1[words[j].charAt(k) - 'a'] != words[i].charAt(k) || mapping2[words[i].charAt(k) - 'a'] != words[j].charAt(k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(check(i, j, words)){
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
