/**
 * 등록 번호 : 60057번  
 * 등록 제목 : 문자열 압축
 * 현재 상태 : 완료 ✔️
 */
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++){
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            StringBuilder result = new StringBuilder();
            
            for(int j = i; j <= s.length(); j += i){
                String next = s.substring(j, j + i > s.length() ? s.length() : i + j); // 다음 문자 추출
                if(zipStr.equals(next)) zipLevel++; // 다음 문자와 현재 문자가 같으면 zipLevel증가
  	            // (압축이 안됬을 경우는 공백, 압축이 됬을경우 zipLevel을 붙여줌) + 압축할 문자를 넣어줌,                 
	              else{
                    result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                    zipStr = next;      // 다음 문자를 압축할 문자로 지정
                    zipLevel = 1;       // 압축 정도 1로 초기화
                }
            }
            result.append(zipStr);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
