package week13.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5585 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int money;
    static int result = 0;

    static int[] coins = {500, 100, 50, 10, 5, 1};

    public static void input() throws IOException {
        money = Integer.parseInt(br.readLine());
    }

    public static void solution(int charge) {
        for (int coin : coins) {
            if (charge <= 0){
                break;
            }
            result += charge / coin;
            charge -= coin * (charge / coin);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(1000 - money);
        br.close();
    }
}
