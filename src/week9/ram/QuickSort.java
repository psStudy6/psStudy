package week9.ram;
import java.util.*;

public class QuickSort {
	static void swap(int[] a,int aa,int bb) {
		int tmp = a[bb];
		a[bb] = a[aa];
		a[aa] = tmp;		
	}
	static void quickSort(int[] a,int left,int right) {
		int pl=left;//왼쪽 커서
		int pr=right;//오른쪽 커서
		int x=a[(pl+pr)/2];//피벗(가운데 위치의 값)
		
		System.out.printf("a[%d]~a[%d]:{",left,right);
		for(int i=left;i<right;i++)
			System.out.printf("%d,",a[i]);
		System.out.printf("%d}\n",a[right]);
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
	public static void main(String[] args) {
		Random random = new Random();//Random 클래스 선언
		int[] a = new int[10];
		for(int i=0;i<10;i++) a[i]=random.nextInt(50+1);//1~50사이의 값
		for(int i=0;i<10;i++) System.out.print(a[i]+" ");
		System.out.println();
		quickSort(a,0,a.length-1);
		for(int i=0;i<10;i++) System.out.print(a[i]+" ");

	}

}
