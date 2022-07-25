/**
 * 등록 번호 : 2776번  
 * 등록 제목 : 암기왕
 * 현재 상태 : 완료 ✔️
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	// testCaseNumber
		
		while(T-- > 0) {
			Set<Integer> temp = new HashSet();
			int AT = Integer.parseInt(br.readLine());	// arrTestCase Number
			String[] tempArr = br.readLine().split(" ");
			for(int j=0; j<AT; j++) {
				temp.add(Integer.parseInt(tempArr[j]));
			}
			
			int PT =  Integer.parseInt(br.readLine());	// praeTestCase Number
			String[] tempPare = br.readLine().split(" ");
			for(int k=0; k<PT; k++) {
				int pare = Integer.parseInt(tempPare[k]);
				if(temp.contains(pare)) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
