package week8.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 백준 1966 프린터 큐
 * 실버3
 * 
 * 문제 : 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
 * 		1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
 * 		2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 
 * 		   그렇지 않다면 바로 인쇄를 한다.
 * 		현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다.
 * 
 * 핵심 : 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다
*/
public class BoJ1966 {
	
	// 방법
	public int solution(Queue<Integer> queue, int[] arr, int max, int idx) {
		int cnt = 1;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			// 최대값일때 출력
			if (max == num) {
				// 출력순서
				if (idx == 0) {
					return cnt;
				}
				cnt++;
				idx--;
				arr[max]--;
				// 최대값 세팅
				for (int i = max; i > 0; i--) {
					if (arr[i] != 0) {
						max = i;
						break;
					}
				}
			} else {
				// 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다
				idx = idx == 0 ? queue.size() : idx - 1;
				queue.add(num);
			} 
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ1966 boj = new BoJ1966();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			int max = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				arr[num]++; // 중요도 카운트
				max = Math.max(max, num);
			}
			sb.append(boj.solution(queue, arr, max, idx)).append("\n");
		}
		System.out.println(sb);
	}
}
