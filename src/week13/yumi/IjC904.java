package week13.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 인프런 9-4 최대 수입 스케쥴(PriorityQueue 응용문제)
 * 
 * 문제 : N개이 기업에서 강연 요청을 해왔다. 
 * 		각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 		각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 
 * 핵심 : PriorityQueue 사용하여 기간별 최대값 돌출
*/
class Lecture implements Comparable<Lecture> {
	int money;
	int time;
	
	public Lecture(int money, int time) {
		this.money = money;
		this.time = time;
	}

	@Override
	public int compareTo(Lecture o) {
		return o.time - this.time;
	}
}
public class IjC904 {
	
	public int solution(ArrayList<Lecture> list, int max) {
		// date 내림차순으로 정렬
		Collections.sort(list);
		// 가장 큰 값 추출 
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		int idx = 0, sum = 0;
		// date = 가능한 기간 -> maxDat 부터 for문
		for (int day = max; day >= 1; day--) {
			for (; idx < list.size(); idx++) {
				if (list.get(idx).time < day) {
					break;
				}
				// day에 속할 경우 offer
				pQ.offer(list.get(idx).money);
			}
			// max ~ 해당 기간 중 가장 큰 money 추출
			sum += pQ.poll();
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		IjC904 ijc = new IjC904();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Lecture> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list.add(new Lecture(money, time));
			max = Math.max(max, time);
		}
		System.out.println(ijc.solution(list, max));	
	}
}
