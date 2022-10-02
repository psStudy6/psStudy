package week14.woojin;

public class PrG_42842 {
    static int[] answer = new int[2];

    public static int[] solution(int brown, int yellow) {
        int y_width = 1;
        while(true){
            if(yellow % y_width == 0) {
                int y_height = yellow / y_width;
                int b_width = y_width+2;
                int b_height = y_height+2;
                if(b_width >= b_height && (b_width*b_height) - yellow == brown && y_width * y_height == yellow) {
                    answer[0] = b_width;
                    answer[1] = b_height;
                    break;
                }
            }
            y_width++;
        }
        return answer;
    }
}
