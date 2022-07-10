
//프로그래머스 문자열 압축
import java.io.IOException;
import java.util.*;

class Solution {  
public int solution(String str){
 String answer = "";
 str=str+" ";//마지막에 숫자 넣을 공간 추가
 int cnt = 1;
 for(int i=0;i<str.length()-1;i++) {
	 if(str.charAt(i)==str.charAt(i+1)) cnt++; //앞뒤 문자가 같은지 확인하며 cnt를 누적시킴
	 else { //문자 중복이 끝나면 문자와 중복개수(cnt)를 answer에 입력
		 answer+=str.charAt(i);
		 if(cnt>1) answer += String.valueOf(cnt);
		 cnt=1;//초기화
	 }
	 
 }
    
 	return answer.length();

}

public static void main(String args[]) throws IOException{ 
  Solution T =new Solution();
  Scanner sc = new Scanner(System.in);

  String input=sc.nextLine();
  System.out.println(T.solution(input));
 

  
 sc.close();
  
  
  
}
}
