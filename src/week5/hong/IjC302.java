/**
 * 문제 제목 : 026. 공통원소 구하기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> 🔸 (half right)
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class IjC302 {
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int oneLen = Integer.parseInt(br.readLine());
		String[] oneData = br.readLine().split(" ");
		int twoLen = Integer.parseInt(br.readLine());
		String[] twoData = br.readLine().split(" ");

		ArrayList<Integer> oneList = new ArrayList<>();
		ArrayList<Integer> twoList = new ArrayList<>();
		for(int i=0; i<oneLen; i++) {
			oneList.add(Integer.parseInt(oneData[i]));
		}
		for(int k=0; k<twoLen; k++) {
			twoList.add(Integer.parseInt(twoData[k]));
		}

		oneList.retainAll(twoList);
		oneList.sort(Comparator.naturalOrder());
		for(int x : oneList) {
			bw.write(x + " ");
		}
		bw.flush();
		bw.close();
	}

}


// =============================================================== //

import java.util.*;

class Main {
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.sort(a); // 입력받은 배열을 오름차순 정렬한다
		Arrays.sort(b); // 입력받은 배열을 오름차순 정렬한다
		int p1 = 0, p2 = 0; // 2개의 포인트를 0부터 시작하도록 선언한다
		while (p1 < n && p2 < m) { // 두개의 포인터중 길이가 넘칠경우 정지하는 루프 시작
			if (a[p1] == b[p2]) { //두개의 값이 같으면 (교집합이면)
				answer.add(a[p1++]); // 두 포인터 증가
				p2++; // 두 포인터 증가
			} else if (a[p1] < b[p2])
				p1++; // 더 작은쪽의 포인터를 증가
			else
				p2++; // 더 작은쪽의 포인터를 증가
		}
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = kb.nextInt();
		}
		int m = kb.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = kb.nextInt();
		}
		for (int x : T.solution(n, m, a, b))
			System.out.print(x + " ");
	}
}
