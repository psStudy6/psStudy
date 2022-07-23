package week5.soram;
import java.util.*;
import java.io.*;
//수 정렬하기 3
//시간초과,,,
public class BOJ10989 {
	
	public static void main(String[] args)throws IOException {
		BOJ10989 T = new BOJ10989();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for(int x : arr) System.out.println(x);
		
		
	}
}
