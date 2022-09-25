package week13.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/** 인프런 9-3 결혼식
 * 
 * 문제 : 현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
 * 		각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
 * 		현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 
 * 
 * 핵심 : 일정이 겹치는 최대 인원 찾기 문제 
 * 		-> 시작시간, 종료시간을 일렬로 정렬
 * 		-> 시작일 경우 cnt++  
 * 		-> 종료일 경우 cnt--
 * 		=> maxCnt 구함  
 * 		
*/
class Time implements Comparable<Time> {
	int time; // 시작 또는 종료시간
	char state;
	
	public Time(int time, char state) {
		this.time = time;
		this.state = state;
	}

	@Override
	public int compareTo(Time o) {
		if (this.time == o.time) {
			return this.state - o.state; // 'e' 종료 - 's' 시작 순서 -> 종료시각에는 인원 포함X
		}
		return this.time - o.time;
	}
}

public class IjC903 {
	
	public int solution(ArrayList<Time> list) {
		Collections.sort(list);
		int cnt = 0, maxCnt = 0;
		for (Time time : list) {
			// 시작일 경우 cnt++ 
			if (time.state == 's') {
				cnt++;
			} else { // 종료일 경우 cnt--;
				cnt--;
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		return maxCnt;
	}
	
	public static void main(String[] args) throws IOException {
		IjC903 ijc = new IjC903();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Time> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Time(Integer.parseInt(st.nextToken()), 's'));
			list.add(new Time(Integer.parseInt(st.nextToken()), 'e'));
		}
		System.out.println(ijc.solution(list));	
	}
}
