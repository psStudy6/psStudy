package example;
import java.util.*;
/* 버블 정렬(ver1)
 * 
 */
public class Sort {
	
	//a[idx1]와 a[idx2]의 값을 바꾼다.
	public static void swap(int[] a,int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2]=t;
	}
	
	//버블 정렬
	static void bubbleSort(int[] a,int size) {
		for(int i=0;i<size-1;i++) {
			for(int j=0;j<size-1;j++) {
				if(a[j]>a[j+1]) {
					swap(a,j,j+1);			
				/* 현재 원소가 다음 원소보다 클 경우
				 * 서로 원소의 위치를 교환한다.
				 */
				}
			}
		}
	}
  //향상된 버블 정렬,정렬이 완성되어 모두 pass하게 되면 정렬완료로 보고 종료시킨다.
	static void bubbleSort2(int[] a,int size) {
		for(int i=0;i<size-1;i++) {
			int exchg = 0;
			for(int j=0;j<size-1;j++) {
				if(a[j]>a[j+1]) {
					swap(a,j,j+1);	
					exchg=0;
				/* 현재 원소가 다음 원소보다 클 경우
				 * 서로 원소의 위치를 교환한다.
				 */
				if(exchg == 0) break;
				//교환이 이루어지지않으면 종료
				}
			}
		}
  //선택 정렬
    static void selectionSort(int[] a,int n) {
		for(int i=0;i<n-1;i++) {
			int min=i;
			//아직 정렬되지 않은 부분엣 가장 작은 요소의 인덱스를 기록
			for(int j=i+1;j<n;j++)
				if(a[j]<a[min])
					min=j;
			swap(a,i,min);
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
	public static void main(String[] args) {
		Random random = new Random();//Random 클래스 선언
		int[] a = new int[10];
		for(int i=0;i<10;i++) a[i]=random.nextInt(100);//0~99사이의 값
		for(int j=0;j<a.length;j++)System.out.print(a[j]+" ");
		System.out.println();
		bubbleSort(a,a.length);
		for(int j=0;j<a.length;j++)System.out.print(a[j]+" ");
		
	}

}
