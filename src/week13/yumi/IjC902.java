package week13.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/** 인프런 9-2 회의실 배정
 * 
 * 문제 : 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 		단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
*/

class Meeting implements Comparable<Meeting> {
	int stt;
	int end;
	
	public Meeting(int stt, int end) {
		this.stt = stt;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) {
			return this.stt - o.stt;
		}
		return this.end - o.end;
	}
}

public class IjC902 {
	
	public int solution(ArrayList<Meeting> list) {
		int cnt = 0;
		int endTime = 0;
		Collections.sort(list);
		for (Meeting meeting : list) {
			if (endTime <= meeting.stt) {
				endTime = meeting.end;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		IjC902 ijc = new IjC902();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Meeting> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		System.out.println(ijc.solution(list));
	}
}
