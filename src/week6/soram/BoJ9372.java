package week6.soram;
import java.util.*;
import java.io.*;

/*상근이의 여행
최대한 적은 종류의 비행기 탑승
노드 -1를 구하기
노드가 N개 있을 때 노드끼리 모두 연결되게 하기 위해서는 최소 N-1 개의 간선이 필요하다.
*/
public class BoJ9372 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());//국가수
			int m = Integer.parseInt(st.nextToken());//비행기종류
			
			for(int j=0;j<m;j++) {
				st=new StringTokenizer(br.readLine());
				//들어오는 입력값은 모두 받아줘야 끝난다.
				
			}
			sb.append(n-1+"\n");//테스트케이스 마다 국가수-1을 StringBuilder에 입력해준다.
			
			
		}
		
		System.out.println(sb);
		
	}

}
