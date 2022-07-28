
/**
 * 문제 제목 : 035. 아나그램(해쉬)
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️ (Success)
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class IjC402 {

	public static void main(String[] args) throws IOException {
		String msg = "NO";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		HashMap<Character, Integer> mapA = new HashMap<>();
		HashMap<Character, Integer> mapB = new HashMap<>();

		for(char T : a.toCharArray()) {
			mapA.put(T, mapA.getOrDefault(T, 0)+1);
		}

		for(char P : b.toCharArray()) {
			mapB.put(P, mapB.getOrDefault(P, 0)+1);
		}

		if(mapA.equals(mapB)) {
			msg = "YES";
		}

		System.out.println(msg);
	}
}

// =============================================================== //

import java.util.*;

public class Main {
	public String solution(String str1, String str2) {
		String answer = "NO";
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (char x : str1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		for (char x : str2.toCharArray()) {
			map2.put(x, map2.getOrDefault(x, 0) + 1);
		}
		if (map.equals(map2)) {
			return "YES";
		} else
			return answer;

	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str1 = kb.next();
		String str2 = kb.next();
		System.out.println(T.solution(str1, str2));
	}
}
