package week6.woojin;

/*
    Site : Infrean Java Coding Site
    title : 학급 회장
    number : 04강 01번
    subject : HashMap
    my velog link :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class IjC0401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        String maxKey = " ";
        String[] input = br.readLine().split("");
        HashMap<String, Integer> president = new HashMap<>();

        for (int i = 0; i < n; i++) {
            president.put(input[i], president.getOrDefault(input[i], 0) + 1);
        }

        for (String s : president.keySet()) {
            if(max < president.get(s)) {
                max = president.get(s);
                maxKey = s;
            }
        }

        System.out.println(maxKey);
        br.close();
    }
}
