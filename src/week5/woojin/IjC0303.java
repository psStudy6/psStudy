package week5.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : Infrean Java Coding Site
    title : 최대 매출
    number : 03강 03번
    subject : slicing window
 */

public class IjC0303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] sales = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sales[i] = Integer.parseInt(input[i]);
        }
        System.out.println(solution(n, k, sales));
        br.close();
    }

    private static int solution(int n, int k, int[] sales) {
        int max = 0;
        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += sales[j];
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
