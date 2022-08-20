package week5.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 인프런 3-2 공통원소 구하기
 * 
 * 문제 : A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램
 *         원소가 중복되어 주어지지 않습니다.
 * 
 * 
*/
public class IjC302 {
    
    public String solution(int aLen, int[] aArr, int bLen, int[] bArr) {
        StringBuffer sb = new StringBuffer();
        int aIdx = 0, bIdx = 0;
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        while (aIdx < aLen && bIdx < bLen) {
            if (aArr[aIdx] == bArr[bIdx]) {
                sb.append(aArr[aIdx++]).append(" ");
                bIdx++;
            }
            else if (aArr[aIdx] < bArr[bIdx]) {
                aIdx++;
            }
            else {
                bIdx++;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        IjC302 ijC = new IjC302();
        Scanner sc = new Scanner(System.in);
        int aLen = sc.nextInt();
        int[] aArr = new int[aLen];
        for (int i = 0; i < aLen; i++) {
            aArr[i] = sc.nextInt();
        }
        
        int[] bArr = new int[aLen];
        int bLen = sc.nextInt();
        for (int i = 0; i < bLen; i++) {
            bArr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(ijC.solution(aLen, aArr, bLen, bArr));
    }
    
    // 시간 초과
    public String solution2(int aLen, int[] aArr, int bLen, int[] bArr) {
        StringBuffer sb = new StringBuffer();
        int bIdx = 0;
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        
        for (int a = 0; a < aLen; a++) {
            if (aArr[a] > bArr[bLen-1] || bIdx == bLen-1) {
                break;
            }
            for (int b = bIdx; b < bLen; b++) {
                if (aArr[a] < bArr[b]) {
                    bIdx = b;
                    break;
                }
                if (aArr[a] == bArr[b]) {
                    sb.append(aArr[a]).append(" ");
                }
            }
        }
        return sb.toString();
    }
    
    public static void main1(String[] args) throws IOException {
        IjC302 ijC = new IjC302();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aLen = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aArr = new int[aLen];
        for (int i = 0; i < aLen; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] bArr = new int[aLen];
        int bLen = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bLen; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(ijC.solution(aLen, aArr, bLen, bArr));
    }
}