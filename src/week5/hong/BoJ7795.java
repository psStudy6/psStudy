/**
 * 등록 번호 : 7795번  
 * 등록 제목 : 먹을 것인가 먹힐 것인가
 * 현재 상태 : ✔️ ()
 */
 
/**
 * 문제이해
 * A만 B를 비교하여 A가 더 높다면 출력 값에 카운트 한다.
 * 2 밴다이어그램 
 *
 * 5 3 - A & B 각 숫자
 * 8 1 7 3 1 - A의 숫자
 * 3 6 1 - B의 숫자
 * 
 * 3 4 - A & B 각 숫자
 * 2 13 7 - A의 숫자
 * 103 11 290 215 - B의 숫자
 * 
 * 예제 입력
 * 2
 * 5 3
 * 8 1 7 3 1
 * 3 6 1
 * 3 4
 * 2 13 7
 * 103 11 290 215
 *
 * 예제 출력
 * 7
 * 1
 */

package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BoJ11719 {
	static void cat(){System.out.print("\\    /\\\n )  ( ')\n(  /  )\n \\(__)|");}
	/** 로직 0 / 시간초과 ✔️
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCaseCount 	= Integer.parseInt(br.readLine());
		long s_time = System.currentTimeMillis();
		String[] cntMax = new String[testCaseCount];
		
		for(int i=0; i<testCaseCount; i++) {
			String[] testCase 	= br.readLine().split(" ");
			int[] sample 		= new int[Integer.parseInt(testCase[0])];
			int[] pare			= new int[Integer.parseInt(testCase[1])];
			String[] sampleData = br.readLine().split(" ");
			String[] pareData 	= br.readLine().split(" ");

			for(int j=0; j<sample.length; j++){
				sample[j] = Integer.parseInt(sampleData[j]);
			}
			for(int k=0; k<pare.length; k++){
				pare[k] = Integer.parseInt(pareData[k]);
			}

			int cnt = 0;
			for(int s=0; s<sample.length; s++) {
				for(int p=0; p<pare.length; p++) {
					// System.out.println("sample[s] : " + sample[s] + " / pare[p] : " + pare[p]);
					if(sample[s] > pare[p]) cnt++;
				}
				cntMax[i] = String.valueOf(cnt);
			}			
			bw.write(cntMax[i] + " ");
		}
		long e_time = System.currentTimeMillis();
		double d_time = (double)(e_time - s_time)/1000;
		System.out.println("process time : " + d_time);
		bw.flush();
		bw.close();
	}
 */
 
  public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int testCaseCount = Integer.parseInt(br.readLine());
     for(int i=0; i<testCaseCount; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int A = Integer.parseInt(st.nextToken());
         int B = Integer.parseInt(st.nextToken());
         int[] sample = new int[A];
         int[] pare = new int[B];

         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < A; j++) {
             sample[j] = Integer.parseInt(st.nextToken());
         }

         st = new StringTokenizer(br.readLine());
         for(int k=0; k<B; k++) {
             pare[k] = Integer.parseInt(st.nextToken());
         }

         Arrays.sort(sample); 
         Arrays.sort(pare);

         int count = 0;
         for(int j=0; j<sample.length; j++){
             for(int k=0; k<pare.length; k++){
                 if(sample[j]<=pare[k]) {
                     break;
                 }
                 else
                     count++;
             }
         }
         System.out.println(count);
     }
 }
}
