package week6.soram;
import java.util.*;
import java.io.*;

/*철벽보안 알고리즘
제 1 공개키 : 한번만 사용된 단어들로 <- 평문에 포함된 단어들을 제시
제 2 공개키 : 제 1 공개키의 단어들을 재배치하여 만듬 <- 암호화 순서 제시

*/
public class BoJ9322 {
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());//테스트 케이스의 개수
	StringBuilder sb = new StringBuilder();
	while(T-->0) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //한문장의 단어수
		HashMap<String,Integer> map = new HashMap<>();
		//KEY값으로 단어가 들어오므로 String을 key로 지정한다.
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) { //제 1 공개키를 map에 넣는다.
			map.put(st.nextToken(),i);
		}
		st = new StringTokenizer(br.readLine());
		for(int q=0;q<n;q++) { //제 2 공개키의 배열방식을 찾는다(순서를 arr에 저장)
			String key = st.nextToken();
			arr[q]=map.get(key); //순서를 저장
		}
		st=new StringTokenizer(br.readLine());
		String tmp[] = new String[n];
		for(int k=0;k<n;k++) {
			tmp[arr[k]]=st.nextToken();//제 2공개키의 순서대로 tmp에 암호화된 키를 복호화한다.
		}
		for(int j=0;j<n;j++) {
			//System.out.print(tmp[j]+" ");
			sb.append(tmp[j]).append(' ');
		}
		sb.append('\n');
		
		
		
	}
	System.out.println(sb);
		
	}

}
