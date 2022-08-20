package week9.ram;
import java.util.*;
import java.io.*;
/* 수 정렬하기(오름차순 : 키 값이 작은 순으로 정렬)
 * 버블 정렬 & 선택 정렬 & 삽입 정렬 & 퀵 정렬
 * 모두 구현해보기
 */

public class Main {
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
		for(int i=0;i<size-1;i++) {
			for(int j=size-1;j>i;j--){
				if(a[j-1]>a[j])
					swap(a,j-1,j);
			}
			
		}
		
	}
	static void bubbleSort2(int[] a,int size) {
		for(int i=0;i<size-1;i++) {
			int exchg=0;
			
			
			for(int j=size-1;j>i;j--){
				//System.out.print("j값:"+j+" ");
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					exchg++;
				}
				
			}
			if(exchg==0) break;
			
		}
		
	}
	static void bubbleSort3(int[] a,int size) {
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
	static void selectionSort(int[] a,int size) {
		/* 가장 작은 값으 요소를 맨 앞으로 옮긴다.
		 * 두번째로 작은 요소를 선택하여 정렬
		 * 아직 정렬하지 않은 부분에서 값이 가장 작은 요소를 선택하고 아직 정렬하지 않은 부분의 첫번째 요소와 교환
		 * 
		 */
		for(int i=0;i<size-1;i++) {
			int min=i; //아직 정렬되지 않은 부분에 가장 작은 요소의 인덱스 기록
			
			for(int j=i+1;j<size;j++) {
				if(a[j]<a[min])
					min=j;
				}
			swap(a,i,min);
		}
		
		
	}
	//삽입정렬 구현,swap 메소드 사용x
	static void insertSort(int[] a,int n) {
		for(int i=1;i<n;i++) {
			int j;
			int tmp=a[i];
			for(j=i;j>0&&a[j-1]>tmp;j--)
				//선택된 요소 tmp,즉 a[i] 앞의 요소보다 작은 값일 경우
				//위치 교환
				a[j]=a[j-1];
			a[j]=tmp;
			
		}
	}
	static void quickSort(int[] a,int left,int right) {
		int pl=left;//왼쪽 커서
		int pr=right;//오른쪽 커서
		int x=a[(pl+pr)/2];//피벗(가운데 위치의 값)


		do {
			while(a[pl]<x) pl++;//피벗보다 큰 값을 찾지못한 경우 pl을 계속 증가시킴
			while(a[pr]>x) pr--;//피벗보다 작은 값을 찾지못한 경우 pr을 계속 증가시킴
			if(pl<=pr) swap(a,pl++,pr--); 
			/*값을 찾아서 while문 두개를 모두 빠져나오면 swap 메소드 실행*/
		}while(pl<=pr);
		//System.out.println("x값:"+x);
		//for(int i=0;i<10;i++) System.out.print(a[i]+" ");
		if(left<pr) quickSort(a,left,pr);
		if(pl<right) quickSort(a,pl,right);
	}
    static void arrSort(int[] arr){
        Arrays.sort(arr);
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(br.readLine());
			
		}
         //arrSort(a);
        //quickSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++) sb.append(a[i]).append("\n");
		System.out.println(sb);
		
		

	}

}
