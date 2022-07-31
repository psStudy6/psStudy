package week6.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

/** 인프런 4-3 매출액의 종류
 * 
 * 문제 : 
 * 
 * 핵심 : -
*/
public class IjC403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		StringBuffer sb = new StringBuffer();
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int money = Integer.parseInt(st.nextToken());
			arr[i] = money;
			// k일까지 매출 저장
			if (cnt++ < k) {
				map.put(money, map.getOrDefault(money, 0) + 1);
			}
			if (cnt == k) {
				if (i-4 >= 0) {
					// 이전 값 삭제
					int preMoney = arr[i-4];
					if (map.get(preMoney) == 1) {
						map.remove(preMoney);
					} else {
						map.replace(preMoney, map.get(preMoney)-1);
					}
				}
				// 매출 종류 개수
				sb.append(map.size()).append(" ");
				cnt--;
			}
		}
		System.out.println(sb);
	}
}
