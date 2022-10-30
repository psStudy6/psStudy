package week16.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Chapter implements Comparable<Chapter> {
	int day;
	int page;
	
	public Chapter(int day, int page) {
		this.day = day;
		this.page = page;
	}

	@Override
	public int compareTo(Chapter o) {
		double thisPer = this.page / (double)this.day;
		double oPer = o.page / (double)o.day;
		if (thisPer == oPer) {
			return o.day - this.day;
		}
		if (oPer > thisPer) {
			return 1;
		}
		return -1;
	}
}


public class BoJ16493 {

	private int solution(int n, List<Chapter> list) {
		Collections.sort(list);
		
		int daySum = 0;
		int pageSum = 0;
		for (Chapter chapter : list) {
			if (daySum + chapter.day <= n) {
				daySum += chapter.day;
				pageSum += chapter.page;
			}
		}
		return pageSum;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ16493 boj = new BoJ16493();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Chapter> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int page = Integer.parseInt(st.nextToken());
			list.add(new Chapter(day, page));
		}
		System.out.println(boj.solution(n, list));
	}
}
