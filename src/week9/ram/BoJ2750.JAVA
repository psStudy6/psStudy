package week9.ram;
import java.util.*;
import java.io.*;
/* 수 정렬하기(오름차순 : 키 값이 작은 순으로 정렬)
 * 버블 정렬 & 선택 정렬 & 삽입 정렬 
 * 모두 구현해보기
 */

//버블정렬3
public class BoJ2750 {
	static void swap(int[] a,int aa,int bb) {
		int tmp = a[bb];
		a[bb] = a[aa];
		a[aa] = tmp;		
	}
	static void bubbleSort(int[] a,int size) {
		/* 이전 요소와 다음 요소를 크기 비교 후
		 * 작은 것이 앞에 오도록 정렬
		 * 이중 for문을 이용
		 * 비교 횟수 : 1+2+ ... +n-1=n(n-1)/2
		 * 시간복잡도 O(n^2)
		 */
		int k=0; //a[k]보다 앞쪽은 정렬을 마친 상태
		while(k<size-1) {
			int last = size - 1;//마지막으로 요소를 교환한 위치
			for(int j=size-1;j>k;j--) 
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					last=j;
				}
				k=last;
			
		}
	}
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(br.readLine());
			
		}
		//System.out.println();
		//for(int j=0;j<a.length;j++)System.out.print(a[j]+" ");
		
		//System.out.println();
		bubbleSort(a,a.length);
		for(int j=0;j<a.length;j++)System.out.println(a[j]);
		
		

	}

}
