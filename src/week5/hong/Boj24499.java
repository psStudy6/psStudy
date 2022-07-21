/**
 * 등록 번호 : 24499번  
 * 등록 제목 : blobyum
 * 현재 상태 : ✔️ (success) 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BoJ24499 {
	static void cat(){System.out.print("\\    /\\\n )  ( ')\n(  /  )\n \\(__)|");}
	/* 시간 초가 및 잘못된 로직
	public static void main(String[] args) {
		BoJ24499 M = new BoJ24499();
		Scanner in = new Scanner(System.in);
		
		int pie = in.nextInt(); // 파이의 총 조각
		int sum = in.nextInt(); // 더 해야하는 갯수
		
		int[] arr = new int[pie+1]; // 파이의 총 갯수 만큼 배열
		
		
		for(int i=0; i<pie; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(M.solution(pie, sum, arr));
		in.close();
	}
	
	public int solution(int pie, int sum, int[] arr) {
		// CheckPoint. 	sum의 갯수 만큼 두가지를 더 해야하는데 최대값을 구해야한다. 
		// 				2중 for -> if -> if -> answer
		int answer = 0;
		int pare = 0;
		
		for(int i=0; i<pie; i++) {
			for(int j=0; j<pie+1; j++){
				if(arr[i] != arr[j]){
					pare = arr[i] + arr[j];
					// System.out.println("arr[i] : " + arr[i] + " / arr[j] : " + arr[j] + " / pare : " + pare);
					if(answer < pare) {
						answer = pare;
						// System.out.println("answer : " + answer);
					}
				}				
			}
		}
		
		return answer;
	}
	*/
	
	/* 테스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String test = br.readLine();
		
		StringTokenizer st = new StringTokenizer(test);
		
		while(st.hasMoreTokens()) {
			bw.write(st.nextToken() + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	*/
	
	/* 시간 초가 및 잘못된 로직
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String pieAndSum = br.readLine();	// 파이의 총 개수와 더 해야하는 갯수 String
		String pieCount = br.readLine();	// 파이들의 값
		StringTokenizer st = new StringTokenizer(pieAndSum);
		StringTokenizer pc = new StringTokenizer(pieCount);

		int pie = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int[] arr = new int[pie];
		
		for(int i=0; i<pie; i++) {
			arr[i] = Integer.parseInt(pc.nextToken());
		}
		
		int pare = 0;
		int answer = 0;
		for(int i=0; i<pie; i++) {
			for(int j=0; j<pie; j++){
				if(arr[i] != arr[j]){
					pare = arr[i] + arr[j];
					System.out.println("arr[i] : " + arr[i] + " / arr[j] : " + arr[j] + " / pare : " + pare);
					if(answer < pare) {
						answer = pare;
						System.out.println("answer : " + answer);
					}
				}
			}
		}
		
		test
		System.out.println("pie : " + pie + " / sum : " + sum);
		for(int d : arr) {
			System.out.println(d);
		}
		

		bw.write(answer + "\n");
		
		bw.flush();
		bw.close();
	}
	*/
	
	/* 시간 초과
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//String pieAndSum = br.readLine();	// 파이의 총 개수와 더 해야하는 갯수 String
		//String pieCount = br.readLine();	// 파이들의 값
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer pc = new StringTokenizer(br.readLine());

		int pie = Integer.parseInt(st.nextToken()), sum = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0; i<pie; i++) {
			list.add(Integer.parseInt(pc.nextToken()));			
		}
		list.addAll(list);
		
		int pare = 0, answer = -1;
		for(int j=0; j<pie; j++) {
			pare = 0;
			for(int k=j; k<j+sum; k++) {
				pare += list.get(k);
			}			
			if(pare > answer) answer = pare;
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	*/
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] n_k = br.readLine().split(" ");
		String[] tasteArr = br.readLine().split(" ");
		int p_cnt = Integer.parseInt(n_k[0]);
		int k_cnt = Integer.parseInt(n_k[1]);
		
		long s_time = System.currentTimeMillis();
		int N = p_cnt;
		int K = k_cnt;
		
		int[] arr = new int[N];
		for(int idx = 0; idx <arr.length; idx++){
			//arr[idx] = idx+1;
			arr[idx] = Integer.parseInt(tasteArr[idx]);
		}
		
		int sum = 0;
		for(int idx = 0 ; idx <K; idx++){
			sum += arr[idx];
		}
		// System.out.println("0 ~ "+(K-1) +" " + sum); - test
		int max = sum; 
		int nextIdx = 0;
		for(int idx = 1 ; idx <N; idx++){
			nextIdx = idx + K - 1;
			if(nextIdx >= N){
				nextIdx =  nextIdx - N;
			}
			sum = sum - arr[idx-1];
			sum = sum + arr[nextIdx];
			// System.out.println(idx + " ~ " +nextIdx + " " + sum); - test
			if(sum > max){
				max = sum;
			}
		}
		
		System.out.println(max);
		long e_time = System.currentTimeMillis();
		double d_time = (double)(e_time - s_time)/1000;
		System.out.println("process time : " + d_time);
	}
	
}
