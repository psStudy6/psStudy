package week19.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BoJ12761 {
    static int n,m,A,B;
    static int[] stone = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        n = Integer.parseInt(input[2]);
        m = Integer.parseInt(input[3]);
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        stone[n] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == m) {
                return stone[x]-1;
            }
            for (int i=0;i<8;i++) {
                int dx = check(i, x);
                if (0<=dx && dx <100001 && stone[dx]==0) {
                    stone[dx] = stone[x]+1;
                    q.add(dx);
                }
            }
        }
        return stone[m]-1;
    }

    public static int check(int index, int x) {
        if(index == 0) return x-1;
        else if(index == 1) return x+1;
        else if(index == 2) return x-A;
        else if(index == 3) return x+A;
        else if(index == 4) return x-B;
        else if(index == 5) return x+B;
        else if(index == 6) return x*A;
        else return x*B;
    }
}
