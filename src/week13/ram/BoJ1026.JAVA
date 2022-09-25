package week13.ram;
import java.util.*;
import java.io.*;
/* 보물(실버4)
 * 배열 A는 재배열 해도 되지만
 * 배열 B는 재배열 X
 * S의 최소값
 * 
 */
public class BoJ1026 {
	static int[] A;
	static int[] B;
	static int N;
	
	public int solution() {
		int S=0;
		Arrays.sort(A);
		
		//System.out.println(Arrays.toString(A));
		Arrays.sort(B);
		for(int i=0;i<N;i++) {
			S+=A[N-1-i]*B[i];
		}
		return S;
	}
	public static void main(String[] args) throws IOException {
		BoJ1026 T = new BoJ1026();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		
		String[] input1 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(input1[i]);
		}
		String[] input2 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			B[i]=Integer.parseInt(input2[i]);
		}
		
		System.out.println(T.solution());
		
		
	}

}
