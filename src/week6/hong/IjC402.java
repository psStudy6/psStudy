
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
import java.util.Scanner;

public class Main{
  public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
    ArrayList<Integer> answer = new ArrayList<>();
    int p1=0, p2=0;
    while(p1<n && p2<m) {
      if(a[p1]<b[p2])answer.add(a[p1++]);
      else answer.add(b[p2++])
    }
    while(p1<n) answer.add(a[p1++]);
    while(p2<m) answer.add(a[p2++]);
    
    return answer;
  }
  
  public static void main(String[] args) {
    Main T = new Main(); 
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] a = new int[n];
    for(int i=0; i<n; i++) {
      a[i] = kb.nextInt();
    }
    int m = kb.nextInt();
    int[] a = new int[m];
    for(int i=0; i<m; i++) {
      a[i] = kb.nextInt();
    }
    for(int x: T.solution(n, m, a, b)) System.out.println(x + " ");
  }
}
