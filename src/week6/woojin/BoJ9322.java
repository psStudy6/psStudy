package week6.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
    Site : BOJ 백준 사이트
    title : 철벽 보안 알고리즘
    number : 9322
    subject : HashMap
    difficulty : silver 4
 */

public class BoJ9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // 복호화 될 <Index, Index> 저장 하는 HashMap
            HashMap<Integer, Integer> map = new HashMap<>();
            String[] publicKey = new String[n];
            String[] input = br.readLine().split(" ");

            // 입력을 publicKey 배열에 저장
            System.arraycopy(input, 0, publicKey, 0, n);

            input = br.readLine().split(" ");

            // 복호화 규칙 저장
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(publicKey[i].equals(input[j])){
                        map.put(j, i);
                    }
                }
            }

            input = br.readLine().split(" ");
            String[] answer = new String[n];
            // 복호화
            for (int i = 0; i < n; i++) {
                answer[map.get(i)] = input[i];
            }
            for (String s : answer) {
                System.out.print(s + " ");
            }
        }
        br.close();
    }
}
