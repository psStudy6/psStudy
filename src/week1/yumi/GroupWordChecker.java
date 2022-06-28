package week1.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 1316 그룹 단어 체커
 */
public class GroupWordChecker {
	// 방법 1 : boolean[26] 사용
	private static int solution(String str) {
		boolean[] arr = new boolean[26];
		arr[str.charAt(0)-'a'] = true; 
		
		for (int i = 1; i < str.length(); i++) {
			int idx = str.charAt(i)-'a';
			if (!arr[idx]) {
				arr[idx] = true;
				continue;
			}
			if (str.charAt(i) != str.charAt(i-1)) {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (t-- > 0) {
			String str = br.readLine();
			cnt += solution(str);
		}
		System.out.println(cnt);
	}
	
	
	// 방법 2 : int[26] arr[idx]++, char[] 사용
	public static int solution2(String str) {
		char[] chArr = str.toCharArray();
		int[] arr = new int[26];
		arr[str.charAt(0)-'a']++;
		
		for (int i = 1; i < chArr.length; i++) {
			int idx = chArr[i]-'a';
			arr[idx]++;
			if(arr[idx] > 1 && chArr[i] != chArr[i-1]) {
				return 0;
			}
		}
		return 1;
	}
	
	
	
	// 방법 3 : int[26] arr[idx]++, str.charAt(i) 사용
	public static int solution3(String str) {
		int[] arr = new int[26];
		arr[str.charAt(0)-'a']++;
		
		for (int i = 1; i < str.length(); i++) {
			int idx = str.charAt(i)-'a';
			arr[idx]++;
			if(arr[idx] > 1 && str.charAt(i) != str.charAt(i-1)) {
				return 0;
			}
		}
		return 1;
	}
}
