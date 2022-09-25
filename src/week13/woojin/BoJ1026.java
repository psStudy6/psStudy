package week13.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
    Site : BOJ 백준 사이트
    title : 보물
    number : 3184
    subject : greedy
    difficulty : silver 4
    velog :
 */

public class BJ_1026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] A,B;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        input =br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(input[i]);
        }
    }

    public static void solution() {
        int sum = 0;

        Integer[] temp = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A);
        Arrays.sort(temp, Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            sum += temp[i] * A[i];
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        br.close();
    }

}