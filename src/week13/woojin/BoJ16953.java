package week13.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16953 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int result = -1;
    static Long A, B;

    public static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
    }

    public static void solution(){
        proc(A,B, 1);
        System.out.println(result);
    }

    public static void proc(long A, long B, int count) {
        if(A == B) {
            if(result == -1 || result > count)
                result = count;
            return;
        }

        if(2*A <= B) {
            proc(2 * A, B, count + 1);
        }
        if(A*10+1 <= B) {
            proc(A * 10 + 1, B, count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        br.close();
    }
}
