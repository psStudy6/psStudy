/**
 * 등록 번호 : 1371번  
 * 등록 제목 : 가장 많은 글자
 * 현재 상태 : 수정 중 ⚠️
 */

// 📄 상태에 대한 중요 상태 설명
// CheckPoint   - 포인트 구간에 대한 설명
// (수정)       - 현재 부족한 로직 수정
// 확인         - Test하기 위한 중간 consle 데이터 점검(System.out.println("필요한 데이터 출력");)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {  
	public static int countChar(String X, char ch) {
        return X.length() - X.replace(String.valueOf(ch), "").length();
    }

	public String solution(String X) {
		    // CheckPoint2. 문자가 들어왔을 때 카운트
        char[] ascCode = new char[26];
        Map<String, Integer> english = new HashMap<String, Integer>();
        String answer = "";
		
        // CheckPoint2. 아스키코드 소문자 [97 - 122]까지 넣기
        for(int i=97; i<123; i++) {
        	int codeNumber = i;
			    // CheckPoint3. 아스키코드로 문자 개수 카운트
        	ascCode[i-97] = (char)codeNumber;
			    english.put(String.valueOf((char)codeNumber), countChar(X, ascCode[i-97]));
        }

		    /* 확인1
        for(Entry<String, Integer> entry : english.entrySet()) {
        	System.out.println("확인 1 : [Key] : " + entry.getKey() + "  |  [value] : " + entry.getValue());
        }
        */
    
        // Checkpoint3. HashMap에 있는 데이터 비교하기
        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(english.entrySet());
        
        Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
          @Override
          public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            // 내림차순 정렬
            return o2.getValue().compareTo(o1.getValue());
          }
        });
        
        System.out.println(entryList.get(0));
        
        // Checkpoint4. 제일 갯수가 많은 소문자 알파벳 출력
        for(Entry<String, Integer> entry : entryList) {
        	System.out.println("확인2 : [Key] : " + entry.getKey() + "  |  [value] : " + entry.getValue());
        }
        
        // (수정 Part.2) 제일 갯수가 많은 것은 달성했으나 갯수가 많은 공통 알파벳은 잡지 못하였다.
        answer = entryList.get(0).getKey();
		    return answer;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Main M = new Main();
		Scanner in = new Scanner(System.in);
		String X ="";
		
		// ChackPoint1. 개행 단위로 입력 받기 때문에 추가로 더 받아야한다. - (수정 Part.1) enter를 쳐주지 않으면 데이터 전송이 안된다 
		while(in.hasNextLine()){
			String tmp = in.nextLine();
			if(tmp.isEmpty()){
				break;
			}
			X += tmp;
		}
    in.close();
    
		System.out.println(M.solution(X));
	}
}


