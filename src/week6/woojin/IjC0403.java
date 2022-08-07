package week6.woojin;

/*
    Site : Infrean Java Coding Site
    title : 매출액의 종류
    number : 04강 03번
    subject : HashMap
    my velog link : https://velog.io/@dnwlsrla40/HashMap-%EB%A7%A4%EC%B6%9C%EC%95%A1%EC%9D%98-%EC%A2%85%EB%A5%98
 */

import java.io.*;
import java.util.HashMap;

public class IjC0403 {
    // 내가 푼 방식
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        String[] input = br.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int k = Integer.parseInt(input[1]);
//        int[] sales = new int[n];
//        input = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            sales[i] = Integer.parseInt(input[i]);
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < k; i++) {
//            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
//        }
//        sb.append(map.size()).append(" ");
//        for (int i = k; i < n; i++) {
//            map.put(sales[i - k], map.get(sales[i - k]) - 1);
//            if (map.get(sales[i - k]) == 0)
//                map.remove(sales[i - k]);
//            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
//            sb.append(map.size()).append(" ");
//        }
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }

    // 강의 방식 (two pointer) 크게 차이는 없는 듯
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] sales = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sales[i] = Integer.parseInt(input[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(sales[rt], map.getOrDefault(sales[rt], 0) + 1);
            sb.append(map.size()).append(" ");
            map.put(sales[lt], map.get(sales[lt]) - 1);
            if (map.get(sales[lt]) == 0)
                map.remove(sales[lt]);
            lt++;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
