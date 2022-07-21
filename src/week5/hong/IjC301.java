/**
 * 문제 제목 : 024. 두 배열 합치기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️ (Success)
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class IjC301 {

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int arrayOne = Integer.parseInt(br.readLine());
			int[] arrOneData = new int[arrayOne];
			String[] oneData = br.readLine().split(" ");
			int arrayTwo = Integer.parseInt(br.readLine());
			int[] arrTwoData = new int[arrayTwo];
			String[] twoData = br.readLine().split(" ");

			int[] tempList = new int[arrayOne + arrayTwo];

			for(int i=0; i< arrOneData.length; i++) {
				tempList[i] = Integer.parseInt(oneData[i]);
			}

			for(int j=0; j<arrTwoData.length; j++) {
				tempList[j+arrOneData.length] = Integer.parseInt(twoData[j]);
			}

			Arrays.sort(tempList);
			for(int x : tempList) {
				bw.write(x + " ");
			}

			bw.flush();
			bw.close();
	}

}

// =============================================================== //
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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

		ArrayList<Integer> answer = new ArrayList<>();
		int p1 = 0, p2 = 0;
    
		while (p1 < n && p2 < m) {
			if (a[p1] < b[p2]) 
				answer.add(a[p1++]);
			else
				answer.add(b[p2++]);
		}

		while (p1 < n) 
			answer.add(a[p1++]);
		while (p2 < m) 
			answer.add(b[p2++]);

		for (int integer : answer) {
			System.out.print(integer + " ");
		}
	}
}
