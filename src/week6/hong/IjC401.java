/**
 * 문제 제목 : 034. 학급 회장(영상 후반 HashMap 추가설명)
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️ (Success)
package main;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class IjC401 {
  /** 무식한 방식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String pickpaper = br.readLine();
		ArrayList<String> list = new ArrayList<>();

		for(int i=0; i<T; i++) {
			list.add(String.valueOf(pickpaper.charAt(i)));
		}

		String answer = "A";
		int max = 0, a = 0, b = 0, c = 0, d = 0;

		max = Collections.frequency(list, "A");
		a = Collections.frequency(list, "B");
		b = Collections.frequency(list, "C");
		c = Collections.frequency(list, "D");
		d = Collections.frequency(list, "E");

		if(a > max) {	max = a; answer="B"; }
		if(b > max) {	max = b; answer="C"; }
		if(c > max) {	max = c; answer="D"; }
		if(d > max) {	max = d; answer="E"; }

		System.out.println(answer);
	}
  */  
  
  public static void main(String args[]) {
        Main main = new Main();
	 Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String pick = in.next();
        System.out.println(main.solution(n, pick));
  }
  
  public void solution(int T, String pick) {
    	int result = 0;
    	String answer = "";
	
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
    	Character[] array = new Character[] {'A', 'B', 'C', 'D', 'E'};
		
        for(int i=0; i<array.length; i++) {
          count.put(array[i], 0);
        }
        for(char x : pick.toCharArray()) {
          count.put(x, count.get(x).intValue() + 1);
        }
        for(int i=0; i<count.size(); i++) {
          if(count.get(array[i]).intValue() > result) {
            answer = array[i].toString();
          }
        }
        System.out.print(answer);
  }
}

// =============================================================== //
import java.util.*;

public class Main {
	public char solution(int n, String s) {
		char answer = ' ';
		HashMap<Character, Integer> map = new HashMap<>();
		for (char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (char key : map.keySet()) { 
			if (map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String str = kb.next();
		System.out.println(T.solution(n, str));
	}
}
