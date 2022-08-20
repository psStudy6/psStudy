package week5.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 백준 7795 먹을 것인가 먹힐 것인가
 * 
 * 문제 : A는 B를 먹는다. A는 자기보다 크기가 작은 먹이만 먹을 수 있다.
 * 		
 * 핵심 : Two pointers 문제
 * 		A와 B를 오름차 순으로 정렬
 * 		A[a] >= A[a-1] 이고 A[a]가 만들 수 있는 쌍 >= A[a-1]가 만들 수 있는 쌍  
 * 		이미 A[a-1]가 조회한 B[b]는 더 이상 조회할 필요 없음
 * 
 * 테스트 케이스
 * 1. A (8 1 7 3 1) / B (3 6 1) = 7
 * 2. A (2 13 7) / B (103 11 290 215) = 1
 * 3. A (2 3 4) / B (1) = 3
 * 4. A (1 2 3) / B (1 1) = 4
 * 5. A (2 3 4) / B (1 2 3) = 6
 * 6. A (1) / B (2 3) = 0
*/
public class BoJ7795 {
	
	public int solution(int aLen, int bLen, int[] aArr, int[] bArr) {
		int cnt = 0, minCnt = 0, bIdx = 0;
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		
		for (int a = 0; a < aLen; a++) {
			// 오름차순이므로 aArr[a] >= aArr[a-1] 보다 항상 큼
			// aArr[a-1]가 만들 수 있는 쌍은 aArr[a]도 만들 수 있음
			// cnt += aArr[a-1]가 만들 수 있는 쌍 
			cnt += minCnt;
			
			// aArr[a-1] <= bArr[]인 인덱스부터 시작
			for (int b = bIdx; b < bLen; b++) {
				if (aArr[a] <= bArr[b]) {
					bIdx = b; // a가 b보다 작을 시 b를 시작인덱스로 세팅
					break;
				}
				cnt++;
				minCnt = b + 1; // 오름차순이므로 만들 수 있는 쌍 = b까지의 개수
				if (b == bLen - 1) {
					bIdx = b+1; // a가 bArr 전체보다 클 때 처리
					break;
				}
			}
			// a가 bArr 전체보다 크다면 오름차순이므로 aArr의 a 이상은 항상 bArr 전체보다 큼
			// 더이상 조회할 필요 없음
			// cnt += (a+1 ~ 마지막 인덱스까지의 개수) * bArr 개수
			if (bIdx == bLen) {
				cnt += (aLen - a -1) * minCnt;
				break;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ7795 boJ = new BoJ7795();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aLen = Integer.parseInt(st.nextToken());
			int bLen = Integer.parseInt(st.nextToken());
			// a 배열
			st = new StringTokenizer(br.readLine());
			int[] aArr = new int[aLen];
			for (int i = 0; i < aLen; i++) {
				aArr[i] = Integer.parseInt(st.nextToken());
			}
			// b 배열
			st = new StringTokenizer(br.readLine());
			int[] bArr = new int[bLen];
			for (int i = 0; i < bLen; i++) {
				bArr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(boJ.solution(aLen, bLen, aArr, bArr)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
