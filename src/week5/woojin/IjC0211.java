package week5.woojin;

/*
    Site : Infrean Java Coding Site
    title : 임시반장 정하기
    number : 02강 11번
    subject : Array
    my velog link : https://velog.io/@dnwlsrla40/Array-%EC%9E%84%EC%8B%9C%EB%B0%98%EC%9E%A5-%EC%A0%95%ED%95%98%EA%B8%B0
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IjC0211 {
    private static final ArrayList<int[]> classmates = new ArrayList<>();
    private static int max = 0;
    private static int result = 1;

    public static void checkLeader(int[] classmate, int n, int classmateIndex) {
        boolean[] check = new boolean[n];
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                if (check[j] || j == classmateIndex)
                    continue;
                if (classmates.get(j)[i] == classmate[i]) {
                    check[j] = true;
                    count++;
                }
            }
        }
        if (max < count) {
            max = count;
            result = classmateIndex + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] classmate = new int[5];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                classmate[j] = Integer.parseInt(input[j]);
            }
            classmates.add(classmate);
        }

        for (int i = 0; i < n; i++) {
            checkLeader(classmates.get(i), n, i);
        }

        System.out.println(result);
        br.close();
    }
}
