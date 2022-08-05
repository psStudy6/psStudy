package week6.woojin;

/*
    Site : Infrean Java Coding Site
    title : 아나 그램
    number : 04강 02번
    subject : HashMap
    my velog link :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class IjC0402 {
    // 내가 푼 방식
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// String[] input = br.readLine().split("");
// HashMap<String, Integer> mapA = new HashMap<>();
// HashMap<String, Integer> mapB = new HashMap<>();
// for (String s : input) {
// mapA.put(s, mapA.getOrDefault(s, 0) + 1);
// }
// input = br.readLine().split("");
// for (String s : input) {
// mapB.put(s, mapB.getOrDefault(s, 0) + 1);
// }
// for (String s : mapA.keySet()) {
// if(!mapB.containsKey(s)){
// System.out.println("NO");
// br.close();
// return;
// } else if(!mapA.get(s).equals(mapB.get(s))) {
// System.out.println("NO");
// br.close();
// return;
// }
// }
// System.out.println("YES");
// br.close();
// }

    // 기존 값을 감소 시키는 방식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : input) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        input = br.readLine().split("");
        for (String s : input) {
            if(!map.containsKey(s) || map.get(s) == 0){
                System.out.println("NO");
                br.close();
                return;
            }
            map.put(s, map.get(s)-1);
        }
        System.out.println("YES");
        br.close();
    }
}
