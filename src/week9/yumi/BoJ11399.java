package week9.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 백준 11399 ATM
 * 실버4
 * 
 * 문제 : ATM이 1대밖에 없다. 지금 이 ATM앞에 N명의 사람들이 줄을 서있다. 
 * 		 사람은 1번부터 N번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.
 * 		 사람들이 줄을 서는 순서에 따라서, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다. 
 * 		 예를 들어, 총 5명이 있고, P1 = 3, P2 = 1, P3 = 4, P4 = 3, P5 = 2 인 경우를 생각해보자. 
 * 		 [1, 2, 3, 4, 5] 순서로 줄을 선다면, 1번 사람은 3분만에 돈을 뽑을 수 있다. 
 * 		 2번 사람은 1번 사람이 돈을 뽑을 때 까지 기다려야 하기 때문에, 3+1 = 4분이 걸리게 된다. 
 * 		 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램
 * 
 * 핵심 : 오름차순 정렬 
*/
public class BoJ11399 {
	// 1. 퀵 정렬 --------------------------------------------------------------------------------------
	// 14324 KB	 132 ms
	public void quickSort(int[] arr, int stt, int end) {
		int right = partition(arr, stt, end);
		// 좌측배열 - 1개 이상일 경우만 호출
		if (stt < right -1) {
			quickSort(arr, stt, right - 1);
		}
		// 우측배열 - 1개 이상일 경우만 호출
		if (right < end) {
			quickSort(arr, right, end);
		}
	}
	
	public int partition(int[] arr, int stt, int end) {
		int pivot = arr[(stt + end) / 2];
		while (stt <= end) {
			// 좌측배열 중 피봇보다 같거나 큰 값이 있을 때까지
			// 우측배열 중 피봇보다 같거나 작은 값이 있을 때까지
			while (arr[stt] < pivot) stt++;
			while (arr[end] > pivot) end--;
			
			// 좌측배열의 피봇보다 같거나 큰 값과 우측배열의 피봇보다 작은 값의 위치 변경
			if (stt <= end) {
				swap(arr, stt, end);
				stt++;
				end--;
			}
		}
		return stt;
	}
	
	public void swap(int[] arr, int stt, int end) {
		int tmp = arr[stt];
		arr[stt] = arr[end];
		arr[end] = tmp;
	}
	
	
	
	
	// 2. 합병 정렬 --------------------------------------------------------------------------------------
	// 14316 KB	 132 ms
	public void mergeSort(int arr[], int[] tmp, int stt, int end) {
		if (stt < end) {
			// 1. 부분집합으로 분할
			int mid = (stt + end) / 2; // 중앙값
			mergeSort(arr, tmp, stt, mid);     // 좌측배열
			mergeSort(arr, tmp, mid + 1, end); // 우측배열
			// 2~3. 정렬 및 병합
			merge(arr, tmp, stt, mid, end); // 좌측배열과 우측배열 병합
		}
	}
	
	public void merge(int[] arr, int[] tmp, int stt, int mid, int end) {
		// tmp 배열에 복사
		for (int i = stt; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int left = stt;
		int right = mid + 1;
		int idx = stt;
		
		// 2. 각 부분 집합에 대해서 정렬 작업을 완성
		// left <= mid  좌측배열 끝까지
		// rigth <= end 우측배열 끝까지
		while (left <= mid && right <= end) {
			// 좌측배열, 우측배열 중 작은 수를 병합 배열에 배치
			if (tmp[left] <= tmp[right]) {
				arr[idx] = tmp[left++];
			} else {
				arr[idx] = tmp[right++];
			}
			idx++;
		}
		// 좌측배열에 남은 원소가 있을 경우 병합 배열 뒷부분에 복사
		// 우측배열에 남은 원소는 병합배열에 이미 해당 위치에 존재하므로 복사 필요 없음
		for (int i = left; i <= mid; i++, idx++) {
			arr[idx] = tmp[i];
		}
	}
	
	
	
	
	
	// 3. 선택 정렬 --------------------------------------------------------------------------------------
	// 14360 KB	 140 ms
	public void selectionSort(int[] arr) {
		int min;
		// 1. 0부터 n-2까지 오른쪽으로 진행
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			// 2. 기준 요소의 우측에서 최솟값 탐색 (i+1부터 n-1까지)
			for (int j = i+1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			// 3. 가장 작은 원소를 선택 후 기준 원소와 자리를 교환
			swap(arr, min, i);
		}
	}

	
	
	
	
	// 4. 삽입 정렬 --------------------------------------------------------------------------------------
	// 14368 KB	 140 ms
	public void insertionSort(int arr[]) {
		int j, tmp;
		// 1. 1부터 n-1까지 오른쪽으로 진행
		for (int i = 1; i < arr.length; i++) {
			tmp = arr[i];
			j = i;
			// 2. 기준 요소의 좌측에서 탐색 (인덱스 i-1 ~ 0)
			// 	= 기준 요소의 실제 정렬 위치까지 좌측 배열을 한 칸 씩 뒤로 옮김
			while (j > 0 && arr[j-1] > tmp) {
				// 3. 좌측 요소 > 기준요소 일 경우 자리를 교환
				arr[j] = arr[j-1];
				j--;
			}
			// 기준 요소의 실제 정렬 위치에 값 저장
			arr[j] = tmp;
		}
	}
	
	
	
	
	
	
	// 5. 버블 정렬 --------------------------------------------------------------------------------------
	// 14544 KB	 152 ms
	public void bubbleSort(int arr[]) {
		int tmp;
		// 1. n-1부터 1까지 왼쪽으로 진행
		for (int i = arr.length - 1; i > 0; i--) {
			// 2. 0부터 기준 위치-1까지 인접한 두개의 원소를 비교 후 큰 수를 오른쪽에 배치
			//  = 우측에 가장 큰 수가 배치됨
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		//BoJ2750 boJ = new BoJ2750();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 0. Arrays.sort - 통과 14424 KB	 168 ms
		Arrays.sort(arr);
		
		// 1. 퀵 정렬 - 통과
		//boJ.quickSort(arr, 0, arr.length-1);
		
		// 2. 머지 정렬 - 통과
		//int[] tmp = new int[arr.length];
		//boJ.mergeSort(arr, tmp, 0, arr.length-1);
		
		// 3. 선택 정렬 - 통과
		//boJ.selectionSort(arr);
		
		// 4. 삽입 정렬 - 통과
		//boJ.insertionSort(arr);
		
		// 5. 버블 정렬 - 통과
		//boJ.bubbleSort(arr);
		
		int tot = 0;
		int time = 0;
		for (int i = 0; i < arr.length; i++) {
			time += arr[i];
			tot += time;
		}
		System.out.println(tot);
	}
}
