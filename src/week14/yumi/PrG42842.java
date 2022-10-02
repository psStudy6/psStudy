package week14.yumi;

import java.util.Arrays;

/** 프로그래머스 42842 카펫(완전탐색)
*/
public class PrG42842 {
	
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int block = brown + yellow;
        for (int i = 3; i < block/2; i++) {
			int height = i;
			int width = block / i;
			int insideBlock = (width-2)*(height-2);
			if (insideBlock == yellow) {
				answer[0] = width;
				answer[1] = height;
				break;
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		PrG42842 prg = new PrG42842();
		int brown = 10;
		int yellow = 2;
		int[] arr = prg.solution(brown, yellow);
		System.out.println(Arrays.toString(arr));
	}

}
