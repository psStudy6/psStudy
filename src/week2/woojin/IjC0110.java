package week2.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : Infrean Java Coding Site
    title : 가장 짧은 문자거리
    number : 01강 10번
    subject : 문자열
 */

/*
    처음에 temp_dis에 Integer.MAX_VALUE 넣었더니 최대값을 넘어 최소값으로 변해버려서 문자열 길이 보다 큰정도의 수로 줌
 */
public class IjC0110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String sentence = input[0];
        char target = input[1].charAt(0);
        int[] dis = new int[sentence.length()];
        int temp_dis = 101;
        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == target) {
                dis[i] = 0;
                temp_dis = 0;
            } else {
                temp_dis++;
                dis[i] = temp_dis;
            }
        }
        temp_dis = 101;
        for (int i = sentence.length()-1; i >= 0; i--) {
            if(sentence.charAt(i) == target) {
                temp_dis = 0;
            } else {
                temp_dis++;
                if(temp_dis < dis[i])
                    dis[i] = temp_dis;
            }
        }
        for (int di : dis) {
            System.out.print(di + " ");
        }
        br.close();
    }
}
