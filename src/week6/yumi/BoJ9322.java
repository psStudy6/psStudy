package week6.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/** 백준 9322 철벽 보안 알고리즘
 * 실버4
 * 
 * 문제 : 한 단어는 1~10개의 대문자(A-Z)들로 이루어진 문자열이다. 한 문장은 공백으로 구분된 단어들로 이루어졌다.
 * 		 제 1 공개키는 최대 한 번만 사용된 단어들로 되어있다.
 * 		 제 2 공개키는 제 1 공개키의 단어들을 재배치하여 만들어진다.
 * 		 평문(암호화 되지 않은 문장)은 제 1 공개키와 같이 여러 단어들로 되어있지만, 제 1 공개키와 다르게 각 단어들은 중복이 가능하다.
 * 		 암호문(암호화 된 문장)은 평문을 제 2 공개키를 만든 규칙의 반대로 재배치하여 만들어진다.
 * 		 주어진 2개의 공개키와 암호문으로 평문을 복구하라.
 * 
 * 핵심 : 단어의 암호문 인덱스 - 평문 인덱스 쌍을 저장
 * 		암호문 인덱스의 단어 -> 평문 인덱스 위치로 옮기면 평문이 됨
*/
public class BoJ9322 {
	
	// 방법 1 
	// 32648KB	492ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<String>();
			String[] arr = new String[n];
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 단어의 암호문 인덱스 - 평문 인덱스 쌍을 저장
				map.put(i, list.indexOf(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 암호문 인덱스의 단어 -> 평문 인덱스 위치로 옮기면 평문이 됨
				arr[map.get(i)] = st.nextToken();
			}
			for (String word : arr) {
				sb.append(word).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 방법 2 
	// 31608KB	420ms
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			int[] arr = new int[n];
			String[] answerArr = new String[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				map.put(st.nextToken(), i);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 단어의 암호문 인덱스 - 평문 인덱스 쌍을 저장
				arr[i] = map.get(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 암호문 인덱스의 단어 -> 평문 인덱스 위치로 옮기면 평문이 됨
				answerArr[arr[i]] = st.nextToken();
			}
			for (String word : answerArr) {
				sb.append(word).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
