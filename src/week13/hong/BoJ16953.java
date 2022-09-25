package week13.hong;

/**
 * 등록 번호 : 16953번
 * 등록 제목 : A → B
 * 현재 상태 : 성공 ✔️
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (A != B){
            if (B < A) {
                System.out.println(-1);
                System.exit(0);
            }
            if (B % 10 == 1) B /= 10;
            else if (B % 2 == 0) B /= 2;
            else {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
