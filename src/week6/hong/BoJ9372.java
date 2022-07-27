/**
 * 등록 번호 : 9372번  
 * 등록 제목 : 상근이의 여행
 * 현재 상태 : 완료 ✔️
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
    long s_time = System.currentTimeMillis();
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// TestCaseNumber
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		ArrayList<Integer>[] list;
		boolean[] visit;
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int country = Integer.parseInt(st.nextToken());
			int airplane = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[country+1];
			visit = new boolean[airplane+1];
		
			for(int i=0; i<=country; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int j=0; j<airplane; j++) {
				st = new StringTokenizer(br.readLine());
				
				int tempOne = Integer.parseInt(st.nextToken());
				int tempTwo = Integer.parseInt(st.nextToken());
				
				list[tempOne].add(tempTwo);
				list[tempTwo].add(tempOne);
			}
			
			sb.append(country-1 + "\n");
		}
    
    long e_time = System.currentTimeMillis();
		double d_time = (double)(e_time - s_time)/1000;
		System.out.println("process time : " + d_time);
		System.out.println(sb);
	}
}
