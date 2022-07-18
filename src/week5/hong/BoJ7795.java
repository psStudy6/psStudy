/**
 * 등록 번호 : 7795번  
 * 등록 제목 : 먹을 것인가 먹힐 것인가
 * 현재 상태 : 🧪(진행중)
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

// CheckPoint1. 각각의 리스트를 생성하여 A -> B를 비교하는 로직을 생성?
// CheckPoint2. 

// 상상코딩 中0
public class BoJ7795{
  public static void main(String[] args) {
    BoJ7795 M = new BoJ7795();
    Scanner in = new Scanner(System.in);
    
    int num = in.nextInt();
    
    for(int i=0; i<num; i++) {
      int siteOne = in.nextInt();
      int siteTwo = in.nextInt();
    
      // 리스트 생성
      int[] listOne = new int[siteOne]; 
      int[] listTwo = new int[siteTwo];
      
      // 두가지 로직을 하나로 합칠수 없을까?
      for(int j=0; j<siteOne; j++) {
        listOne[j] = in.nextInt();
      }
      
      for(int k=0; k<siteTwo; k++) {
        listTwo[k] = in.nextInt();
      }
    
      System.out.println(M.solution(listOne, listTwo));
  }
  
  public int solution(int[] listOne, int[] listTwo) {
    int answer = 0;
    
    return answer;
  }
}


