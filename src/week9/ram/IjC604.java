package week9.ram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class IjC604 {

    public static int[] solution(int s, int n, int[] work) {
        LinkedList<Integer> cache = new LinkedList<>();
        int[] answer = new int[s];

        for (int i : work) {
            if (cache.contains(i)) { //캐시에 최근 작업이 이미 있다면
                cache.remove((Integer) i);

            }
            cache.addFirst(i);


            if (cache.size() > s) {
                cache.removeLast();
            }

        }

        for (int i = 0; i < s; i++) {
            answer[i] = cache.get(i);
        }

        return answer;
    }
    public static int[] solution2(int s, int n, int[] work) { 
    	/* 강의 풀이 */
        int[] cache = new int[s];

        for (int i : work) {
            int pos = -1;

            for (int j = 0; j < s; j++) {
                if (cache[j] == i) { //캐시에 최근 작업이 이미 있다면
                    pos = j;
                }
            }

            if (pos == -1) { //캐시에 최근 작업이 없다면?
                for (int j = s - 1; j > 0; j--) { //전체 캐시를 한칸씩 뒤로 옮긴다.
                    cache[j] = cache[j - 1];
                }
            } else {  //캐시에 최든 작업이 이미 있다면?
                for (int j = pos; j > 0; j--) { //최근 작업이 있던 위치까지 한칸씩 뒤로 옮긴다.
                    cache[j] = cache[j - 1];
                }
            }

            cache[0] = i; //최근 작업을 맨 앞에 넣는다.
        }

        return cache;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] work = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(s, n, work)) {
            System.out.print(i + " ");
        }

    }
}
