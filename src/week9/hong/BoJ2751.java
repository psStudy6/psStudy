/**
 * 등록 번호 : 2751번
 * 등록 제목 : 수 정렬하기2
 * 현재 상태 : 성공 ✔️
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BoJ2751 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>(T);

        for(int i=0; i<T; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        for (int a : arr) {
            sb.append(a).append('\n');
        }
        System.out.println(sb);
    }
}
