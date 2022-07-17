package week4.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    Site : BOJ 백준 사이트
    title : 참외밭
    number : 2447
    subject : Array
    difficulty : silver 3
 */

public class BJ_2477 {
    static class Node {
        int dir;
        int size;

        Node(int dir, int size) {
            this.dir = dir;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxH = 0, maxW = 0;
        int indexH = 0, indexW = 0;
        int blankH, blankW;
        Node[] arr = new Node[6];
        for (int i = 0; i < 6; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        for (int i = 0; i < 6; i++) {
            // 세로의 최댓값 구하기
            if (arr[i].dir == 1 || arr[i].dir == 2) {
                if (maxW < arr[i].size) {
                    maxW = arr[i].size;
                    indexW = i;
                }
            } else if (arr[i].dir == 3 || arr[i].dir == 4) {   // 가로의 최댓값 구하기
                if (maxH < arr[i].size) {
                    maxH = arr[i].size;
                    indexH = i;
                }
            }
        }

        // 빈공간 가로 구하기 ( 제일 긴 가로 - (제일 긴 세로 양 옆중 작은 세로) )
        if (indexH == 0) {
            blankW = maxW - Math.min(arr[indexH + 1].size, arr[5].size);
        } else if (indexH == 5) {
            blankW = maxW - Math.min(arr[indexH - 1].size, arr[0].size);
        } else {
            blankW = maxW - Math.min(arr[indexH - 1].size, arr[indexH + 1].size);
        }

        // 빈공간 세로 구하기 ( 제일 긴 세로 - (제일 긴 가로 양 옆중 작은 가로) )
        if (indexW == 0) {
            blankH = maxH - Math.min(arr[indexW + 1].size, arr[5].size);
        } else if (indexW == 5) {
            blankH = maxH - Math.min(arr[indexW - 1].size, arr[0].size);
        } else {
            blankH = maxH - Math.min(arr[indexW - 1].size, arr[indexW + 1].size);
        }

        System.out.println(((maxH*maxW) - (blankH*blankW)) * n);
        br.close();
    }
}

