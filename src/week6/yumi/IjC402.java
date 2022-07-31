package week6.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/** 인프런 4-2 아나그램(해쉬)
 * 
 * 문제 : Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 		즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 		길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 * 
 * 핵심 : 각 문자의 개수가 동일하면 Anagram
*/
public class IjC402 {
	// 방법 1
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "YES";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chArr = br.readLine().toCharArray();
		for (char ch : chArr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		chArr = br.readLine().toCharArray();
		for (char ch : chArr) {
			map.put(ch, map.getOrDefault(ch, 0) - 1);
		}
		for (int i : map.values()) {
			if (i != 0) {
				answer = "NO";
				break;
			}
		}
		System.out.println(answer);
	}
	
	// 방법2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "YES";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chArr = br.readLine().toCharArray();
		for (char ch : chArr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		chArr = br.readLine().toCharArray();
		for (char ch : chArr) {
			// 없는 문자이거나 문자의 개수가 더 많은 경우 
			if(!map.containsKey(ch) || map.get(ch) == 0) {
				answer = "NO";
				break;
			}
			map.put(ch, map.get(ch) - 1);
		}
		System.out.println(answer);
	}
}
