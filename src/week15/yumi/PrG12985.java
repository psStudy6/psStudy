package week15.yumi;

/** 프로그래머스 12985 예상 대진표
 * 
*/
public class PrG12985 {

	// 방법 1 : 반타작
	public int solution(int n, int a, int b) {
		int round = 1;
		int num1 = Math.min(a, b);
		int num2 = Math.max(a, b);
		
		// 라운드가 동일할 때까지
		// 하나 차이 날 때 까지 -> 1, 2 O / 2, 3 X
        while(!(num1 % 2 == 1 && num1 == num2 - 1)) {
        	round++;
        	// 반타작 5-3-1 / 6-4-2
            num1 = num1 / 2 + num1 % 2;
            num2 = num2 / 2 + num2 % 2;
        }
        return round;
    }
	
	// 로그2 사용
	// 실패 - 반례 8,4,5 -> 2 => 정답 3
	public int solution2(int n, int a, int b) {
        int cnt = 1;
        int num = Math.abs(a - b);
        if (num % 2 == 1) {
			num++;
		}
        int log = (int)baseLog(num, 2);
        cnt += log;
        if (log == 0) {
        	cnt++;
		}
        return cnt;
    }
	
	static double baseLog(double num, double base) {
		return Math.log10(num) / Math.log10(base);
	}
	
	public static void main(String[] args) {
		PrG12985 prg = new PrG12985();
		//System.out.println(prg.solution2(6, 3, 4));
		//System.out.println(prg.solution2(8, 4, 7));
		System.out.println(prg.solution2(8, 4, 5));
	}
}
