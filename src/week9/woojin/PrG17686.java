package week9.woojin;

/*
    Site : Programmers Algorithm site
    title : 파일명 정렬
    number : 17686
    subject : Sort
    difficulty : Level 2
 */

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public class PrG17686 {

    // 비교 대상이 될 파일명들 (각 파일의 head,number,tail로 나뉘어지고 몇번째로 들어왔는 지 저장)
    static class Word implements Comparable<Word>{
        private String head;
        private String num;
        private String tail;
        private int index;

        public Word(String head, String num, String tail, int index) {
            this.head = head;
            this.num = num;
            this.tail = tail;
            this.index = index;
        }

        @Override
        public int compareTo(Word o) {
            // 1차로 head끼리 비교(대소문자 차이 안두기 위해 다 소문자로 비교)
            if(this.head.toLowerCase(Locale.ROOT).compareTo(o.head.toLowerCase(Locale.ROOT)) == 0){
                // head비교가 동일하다면, number 숫자화 비교(숫자로 변환 시켜 앞의 000제거)
                if(Integer.parseInt(this.num) > Integer.parseInt(o.num))
                    return 1;
                else if(Integer.parseInt(this.num) < Integer.parseInt(o.num))
                    return -1;
                else
                    // 그래도 안되면 index 순서대로 비교
                    return this.index < o.index ? -1 : 1;
            }
            return this.head.toLowerCase(Locale.ROOT).compareTo(o.head.toLowerCase(Locale.ROOT));
        }
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Word[] words = new Word[files.length];
        
        // 각 파일을 head와 number와 tail로 변경
        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            boolean flag = false;

            String[] check = files[i].split("");
            for (int j = 0; j < check.length; j++) {
                // 숫자가 나올때 까지 저장
                if(!flag && Pattern.matches("\\D", check[j])) {
                    head.append(check[j]);
                } else{
                    // 숫자 이후에 다시 숫자가 아닌 것이 올 수 있는데 이를 head에 넣지 않으려고 flag 이용
                    flag = true;
                    // 숫자는 num에 저장
                    if(Pattern.matches("\\d", check[j])) {
                        num.append(check[j]);
                    } else {
                        // head, num 뒤에 나오는 모든 것을 tail에 저장
                        for (int k = j; k < check.length; k++) {
                            tail.append(check[k]);
                        }
                        break;
                    }
                }
            }
            // 나눈 head, num, tail로 word 생성
            words[i] = new Word(head.toString(),num.toString(),tail.toString(),i);
        }

        // 정렬
        Arrays.sort(words);

        // 정렬 한 word를 다시 합쳐 결과 출력
        for (int i = 0; i < answer.length; i++) {
            answer[i] = words[i].head + words[i].num + words[i].tail;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] input = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(input)));
    }
}
