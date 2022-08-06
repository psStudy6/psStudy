package week6.soram;
import java.util.*;
import java.io.*;
//실버4.암기왕
//동규 -> 연종 : M개의 질문
//정수 X
//수첩2를 기준으로 수첩1에 같은 숫자가 있는지 없는지

public class BoJ2776 {
	public int solution(int n) {
		int ans=0;
		return ans;
	}
	public static void main(String[] args) throws IOException {
		//BoJ2776 M = new BoJ2776();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0;i<T;i++) { 
			/* 수첩 1에서 정수를 받아들인다 */
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			//String 배열에 
			HashSet<Integer> hash = new HashSet();
			for(int j=0;j<n;j++) {
				hash.add(Integer.parseInt(tmp[j]));//String -> Integer
			}
			/* 수첩 2에서 정수를 받아들인다 */
			n=Integer.parseInt(br.readLine());
			tmp=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				int input = Integer.parseInt(tmp[j]);
				if(hash.contains(input)==true) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
