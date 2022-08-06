package week6.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/** 백준 1822 차집합
 * 
 * 문제 : 몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램
 * 		첫째 줄에 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수를 출력한다. 
 * 		다음 줄에는 구체적인 원소를 빈 칸을 사이에 두고 증가하는 순서로 출력한다. 
 * 		집합 A에는 속하면서 집합 B에는 속하지 않는 원소가 없다면 첫째 줄에 0만을 출력하면 된다.
 * 
 * 핵심 : 
*/
public class BoJ1822 {
	
	// 방법1 : TreeSet 오름차순 정렬, removeAll - 공통 요소 제거
	//		 375796 KB	2032 ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)) ;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();
		st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			set1.add (Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			set2.add (Integer.parseInt(st.nextToken()));
		}
		// 공통 요소 제거
		set1.removeAll(set2);
		sb.append(set1.size()).append("\n");
		//
		for (Integer num : set1) {
			sb.append(num).append (" ");
		}
		System.out.println(sb.toString());
	}
	
	// 시간 초과 - List도 removeAll을 제공하지만 오름차순을 위해서 Collections.sort 또는 Arrays.sort 쓰면 시간 초과
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)) ;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			list1.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		// 공통 요소 제거
		list1.removeAll(list2);
		//Collections.sort(list1);
		Arrays.sort(list1.toArray());
		sb.append(list1.size()).append("\n");
		// 출력
		for (Integer num : list1) {
			sb.append(num).append (" ");
		}
		System.out.println(sb.toString());
		
	}
}
