package week2.yumi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** 백준 1181 단어 정렬
 * 실버5
 * 
 * 문제 간단 설명 : 알파벳 소문자로 이루어진 N개의 단어 정렬
 * 				1. 길이가 짧은 것부터
 * 				2. 길이가 같으면 사전 순으로
 * 				3. 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력
 * 
 * 핵심 : Comparator로 정렬 사용자화 
*/
public class BoJ1181 {
	// 방법 1 : Collections.sort(list, new Comparator<String>() {}) 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		List<String> li = new ArrayList<String>();
		
		while (t-- > 0) {
			String str = br.readLine();
			// 동일한 단어 있을 시 제외
			if (li.contains(str)) {
				continue;
			}
			li.add(str);
		}
		// 정렬 - 사용자 정의
		Collections.sort(li, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 길이 오름차순
				// 같지 않을 시 길이가 길면 +1, 짧으면 -1 리턴 
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				// 길이가 같을 시 문자 오름차순
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < li.size(); i++) {
			bw.append(li.get(i)).append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	// 방법 2 : Arrays.sort(strArr, new Comparator<String>() {}) 사용
	public static void solution2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String[] strArr = new String[t];
		
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = br.readLine();
		}
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 길이 오름차순
				// 같지 않을 시 길이가 길면 +1, 짧으면 -1 리턴 
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				// 길이가 같을 시 문자 오름차순
				return o1.compareTo(o2);
			}
		});
		String tmp = "";
		for (String str : strArr) {
			// 중복 제거
			if (str.equals(tmp)) {
				continue;
			}
			sb.append(str).append("\n");
			tmp = str;
		}
		System.out.println(sb);
	}
	
}
