/**
 * 등록 번호 : 1822번  
 * 등록 제목 : 차집합
 * 현재 상태 : 완료 ✔️
 */

// ========================================== ▽ 시간 초과 로직 ▽ ========================================== //
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoJ1822 {
	public static void main(String[] args) throws IOException {
		BoJ1822 M = new BoJ1822(); // Method sned The data form solution
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] testCase = br.readLine().split(" "); // Input something in a data

		// test Arrays //
		int[] arr = new int[Integer.parseInt(testCase[0])];		// A graph (output data)
		int[] pare = new int[Integer.parseInt(testCase[1])];	// B graph (pare data)

		// Input Data about A and B //
		String[] AT = br.readLine().split(" ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(AT[i]);
		}
		String[] PT = br.readLine().split(" ");
		for(int j=0; j<pare.length; j++) {
			pare[j] = Integer.parseInt(PT[j]);
		}
		System.out.println(M.solution(arr, pare));
		br.close();
	}

	public String solution(int[] arr, int[] pare) {
		String answer = "";	// Show a user in the data(Output data)

		int[] temp = new int[arr.length + pare.length];
		// how to arratList input data Count ?
		// Maybe A graph + B graph = Max Count ^^*

		// The data sort ASC
		Arrays.sort(arr);
		Arrays.sort(pare);

		/* test Case - 1
		for(int A : arr) {
			System.out.println("arr 후 : " + A);
		}
		for(int B : pare) {
			System.out.println("pare 후 : " + B);
		}
		*/

		int cnt = -1;  // what are you count -1 setting? -> count 0 --> true -> data False
		// Between A graph and B graph = the data in answer and output console
		for(int i=0; i<arr.length; i++) {
			cnt = 0;
			for(int j=0; j<pare.length; j++) {
				if(arr[i] == pare[j]) { // A graph == B graph
					break;
				}
				else { // A graph != B graph
					cnt++;
				}
				if(cnt==pare.length)temp[i] = arr[i];
			}
		}

		/* test Case - 2
		for(int C : temp ) {
			if(C != 0) {
				System.out.println("temp : " + C);
			}
		}
		*/

		int outputCount = 0;
		for(int k=0; k<temp.length; k++) {
			if(temp[k] != 0) {
				outputCount++;
				if(k == temp.length -1) {
					answer += temp[k];
				}
				else {
					answer += temp[k] + " ";
				}
			}
		}

		System.out.println(outputCount);
		return answer;
	}

// ========================================== ▽ 통과 로직 ▽ ========================================== //

 public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCaseA = Integer.parseInt(st.nextToken());
        int testCaseB = Integer.parseInt(st.nextToken());
        Set<Integer> setTemp = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i =0; i < testCaseA; i++) {
        	setTemp.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i =0; i < testCaseB; i++) {
            int pare = Integer.parseInt(st.nextToken());
            if (setTemp.contains(pare))
            	setTemp.remove(pare);
        }

        System.out.println(setTemp.size());
        for(int f : setTemp) {
        	System.out.print(f + " ");
        }
 }
}
