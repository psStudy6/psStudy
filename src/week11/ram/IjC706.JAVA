package week11.ram;
import java.util.*;
import java.io.*;
/* 부분집합 구하기(DFS)
 * 자연수 N이 주어졌을 때 1부터 N까지 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성
 * 공집합은 출력하지 않는다.
 * 부분집합의 개수는 2^n-1개이다.
 */
public class IjC706 {
	static int n; //입력받을 값, 전역변수 선언
	static int[] ch; //출력해야할 값들을 체크해줄 배열
	//전역변수 선언(1 또는 0으로 비교할 것)
	static boolean[] checked;
	public void DFS(int L) {
		if(L == n+1) {
			//DFS함수의 인자값 L이 입력값 N보다 크면 종료 시점은 참이 된다.
			for(int i=0;i<=n;i++) {
				if(ch[i]==1) System.out.print(i+" ");
			}
			System.out.println();
		}else {
			ch[L]=1;
			//배열의 (현재 들어온 인자) 인덱스를 1로 만들고
			DFS(L+1);
			//왼쪽 라인을 태운다.
			
			ch[L]=0; 
			//배열의 (현재 들어온 인자) 인덱스를 0으로 만들고
			DFS(L+1); 
			//오른쪽 라인을 태운다.
		}
	}
	public static void dfs_2(int L) {
		if(L == n+1) {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=n;i++) {
				if(checked[i])sb.append(i+" ");
			}
			if(sb.length()>0)//공집합 제외
				System.out.println(sb.toString());
		}else {
			checked[L]=true; //원소 L을 포함하는 부분집합
			dfs_2(L+1);
			checked[L]=false; //원소 L을 포함하지 않는 부분집합
			dfs_2(L+1);
		}
	}
	
	public static void main(String[] args) {
		IjC706 M = new IjC706();
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); //입력받은 값
		ch = new int[n+1]; //입력받은 값 만큼 배열 크기 초기화
		M.DFS(1);

	}

}
