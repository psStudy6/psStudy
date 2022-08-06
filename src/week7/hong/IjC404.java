/**
 * 문제 제목 : 037. 모든 아나그램 찾기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️ (Success)

import java.util.*;
import java.io.*;

public class Main {
  
  public static void main(String args[]) {
      Main main = new Main();
      Scanner in= new Scanner(System.in);
        
      String S = in.nextLine();
      String T = in.nextLine();
		
      main.solution(S, T);
  }
  
	public void solution(String S, String T) {
	
		HashMap<Character, Integer> count = new HashMap<>();
		HashMap<Character, Integer> countTmp = new HashMap<>();
		
		int result = 0;
		int lt = 0;
		int L = T.length()-1;
		
		for(char x : T.toCharArray()) {
			countTmp.put(x, countTmp.getOrDefault(x,0)+1);
		}
    
		for(int i=0; i<L; i++) {
			count.put(S.charAt(i), count.getOrDefault(S.charAt(i),0)+1);
		}
    
		for(int rt=L; rt<S.length(); rt++) {
			count.put(S.charAt(rt), count.getOrDefault(S.charAt(rt),0)+1);
			
			if(count.equals(countTmp)) {
				result ++;
			}
			count.put(S.charAt(lt), count.get(S.charAt(lt))-1);
			if(count.get(S.charAt(lt)) == 0) {
				count.remove(S.charAt(lt));
			}
			lt++;
		}
    
		System.out.println(result);
	}

}


// =============================================================== //
import java.util.*;

public class Main {
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    String a = kb.next();
    String b = kb.next();
    System.out.println(T.solution(a, b));
  }
  
  public int solution(String a, String b) {
    int answer = 0;
    
    HashMap<Character, Integer> am = new HashMap<>();    
    HashMap<Character, Integer> bm = new HashMap<>();
    
    for(char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0)+1);
    int L = b.length() -1;
    for(int i=0; i<L; i+++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
    
    int lt = 0;
    for(int rt=L; rt<a.length(); rt++) {
      am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
      if(am.equals(bm)) answer++;

      am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
      if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt)); 
      lt++;
    }
    return answer;
  }
}
