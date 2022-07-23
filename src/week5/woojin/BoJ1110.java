package week5.woojin;


/*
    Site : BOJ 백준 사이트
    title : 더하기 사이클
    number : 1110
    subject : 반복문
    difficulty : bronze 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BoJ1110 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int bNum = input / 10, aNum = input % 10;
        int count = 1;

        int temp1 = aNum, temp2 = (bNum + aNum) % 10;

        while (!(temp1 == bNum && temp2 == aNum)) {
            count++;
            int sum = (temp1 + temp2) % 10;
            temp1 = temp2;
            temp2 = sum;
        }

        System.out.println(count);

        // BufferedReader와 String형태의 구현(시간과 메모리가 더 적게 듬)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split("");
//        String bNum, aNum;
//        String temp1, temp2;
//        int count = 1;
//
//        if(input.length==1){
//            bNum = "0";
//            aNum = input[0];
//        }else {
//            bNum = input[0];
//            aNum = input[1];
//        }
//
//        temp1 = aNum;
//        temp2 = String.valueOf((Integer.parseInt(bNum) + Integer.parseInt(aNum)) % 10);
//
//        while(!(temp1.equals(bNum) && temp2.equals(aNum))){
//            count++;
//            String temp = String.valueOf((Integer.parseInt(temp1) + Integer.parseInt(temp2)) % 10);
//            temp1 = temp2;
//            temp2 = temp;
//        }
//
//        System.out.println(count);
//        br.close();
    }
}
