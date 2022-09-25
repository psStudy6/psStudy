package week13.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_1946 {
    static class Score implements Comparable<Score>{
        private int s1;
        private int s2;

        public Score(int s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public int compareTo(Score o) {
            if(this.s1 < o.s1)
                return -1;
            else
                return 1;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void input() throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Score> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                list.add(new Score(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            Collections.sort(list);

            int count = 1;
            int min = list.get(0).s2;

            for (int i = 1; i < n; i++) {
                if(list.get(i).s2 < min){
                    count++;
                    min = list.get(i).s2;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        br.close();
    }
}
