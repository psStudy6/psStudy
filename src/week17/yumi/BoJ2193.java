package week17.yumi;

import java.util.Scanner;

/**
 * 백준 2193 이친수
 *
 * 문제 : 이친수는 0으로 시작하지 않는다.
 *      이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 *      0과 1로만 이루어진 수
 *      N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 */

public class BoJ2193 {

    public static int cnt, N;

    public void addDigit(int digit, int number) {
        if (digit == N) {
            cnt++;
            return;
        }
        if (number != 1 && number % Math.pow(10, digit-1) == 0) {
            addDigit(digit + 1, number * 10 + 1);
        }
        addDigit(digit + 1, number * 10);
    }

    public static int solution(int N) {
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        if (N < 3) {
            return arr[N - 1];
        }
        for (int i = 2; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N - 1];
    }

    public static void main(String[] args) {
        BoJ2193 boj = new BoJ2193();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        /*cnt = 0;
        boj.addDigit(1, 1);
        System.out.println(cnt);*/
        System.out.println(solution(N));
    }
}
