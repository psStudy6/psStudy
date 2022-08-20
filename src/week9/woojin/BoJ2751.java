package week9.woojin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    Site : BOJ 백준 사이트
    title : 수 정렬하기2
    number : 2751
    subject : Sort
    difficulty : silver 2
 */

public class BoJ2751 {

    // 중복이 없다고 문제에 주어져 count sort로 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        // 절대값이 1000000 사이 이므로 2배만큼 할당
        boolean[] arr = new boolean[2000001];
        // 음수를 양수로 바꾸기위해 입력값 보다 1000000만큼 밀어서 index에 저장
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for (int i = 0; i < 2000001; i++) {
            if (arr[i])
                sb.append(i - 1000000).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 검색 해보다 알게 되었는데 Arrays.sort는 dual-pivot Quicksort로 Quicksort이기 때문에 평균이 O(nlogn) 최악이 O(n^2)이다.
    // 그와 다르게 Collections.sort는 합병 및 삽입정렬을 섞은 hybrid sorting algorithm 중 하나인 Timsort를 사용해 O(n)~O(nlogn)의 시간 복잡도를 보장한다.
    // https://st-lab.tistory.com/276 - Timsort 구현 및 설명
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(Integer.parseInt(br.readLine()));
//        }
//        Collections.sort(list);
//
//        for (Integer integer : list) {
//            sb.append(integer).append('\n');
//        }
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }
}
