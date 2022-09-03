package week11.ram;
/* 단순히 재귀를 통하면 n이 커졌을 때 모든 트리를 탐색해야하므로
 * 시간이 오래 걸린다.(비효율적,같은 DFS(K)를 여러번 구하게됨)
 * 또한 재귀함수는 한번 재귀될 때마다 stack frame에 매개변수,지역변수,주소 등이 쌓이기때문
 * 
 */
import java.util.*;
import java.io.*;
public class IjC705 {
	
	public static int DFS(int n) {
		if(n==1) return 1;
		else if(n==2) return 1;
		else return DFS(n-2)+DFS(n-1);
	}
	static int[] fibo;
	public static int DFS_memory(int n) {
		//이미 fibo 배열에 값이 존재한다면, 탐색하지 않고
		if(fibo[n]>0) return fibo[n];
		if(n==1) return fibo[1]=1;
		else if(n==2) return fibo[2]=1;
		else return fibo[n]=DFS_memory(n-2)+DFS_memory(n-1);
	}
	public static void main(String[] args) {
		int n=10;
		for(int i=1;i<=n;i++) System.out.println(DFS(i));
		int j=45;
		fibo=new int[j+1];
		DFS_memory(j);
		for(int i=1;i<=n;i++)System.out.println(fibo[i]);
	}
	

}
