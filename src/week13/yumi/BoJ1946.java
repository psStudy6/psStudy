package week13.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/** 백준 1946 신입사원
 * 실버1
 * 
 * 문제 : 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 
 * 		 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 * 		 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램
 * 
 * 핵심 : 인덱스 순으로 서류 등수가 높으르로 면접 등수로 비교 - 하나라도 등수가 높아야 선발
*/
class Tester implements Comparable<Tester> {
	int test;
	int interview;
	
	public Tester(int test, int interview) {
		this.test = test;
		this.interview = interview;
	}

	// 서류, 면접 오름차순으로 정렬 (등수)
	@Override
	public int compareTo(Tester o) {
		if (o.test == this.test) {
			return this.interview - o.interview;
		}
		return this.test - o.test;
	}
}

public class BoJ1946 {
	
	public int solution(List<Tester> list) {
		Collections.sort(list);
		int cnt = 0, minInterview = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int interview = list.get(i).interview;
			// 인덱스 순으로 서류 등수가 높으르로 면접 등수로 비교 
			if (minInterview >= interview) {
				minInterview = interview;
				cnt++;
			}
		}
		return cnt; 
	}
	
	public static void main(String[] args) throws IOException {
		BoJ1946 boj = new BoJ1946();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<Tester> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Tester(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			sb.append(boj.solution(list)).append("\n");
		}
		System.out.println(sb);
	}
}
