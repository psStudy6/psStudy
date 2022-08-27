package week9.ram;
import java.util.Arrays;
import java.util.Comparator;

public class PrG17686 {
	/* 파일명 정렬(2018 카카오 블라인드 공채)
	 * HEAD:영문대소문자(1st 기준,사전순,대소문자 구분x)
	 * NUMBER:0~99999(앞에 0으로 시작할 수 있다)(2nd 기준)
	 * TAIL:공백또는아무문자,숫자(3rd 들어온 순서)
	 */

    static class File{
        String file_name;
        String head;
        int number;

        public File(String file_name, String head, int number) {
            this.file_name = file_name;
            this.head = head;
            this.number = number;
        }
    }
    
    public static String[] solution(String[] files) {
        

        File[] file_info = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            String[] split = splitFileName(files[i]);
            file_info[i] = new File(files[i], split[0], Integer.parseInt(split[1]));
        }

        Arrays.sort(file_info, new Comparator<File>() {
        	/* 배열은 Arrays.sort() , List는 Collection.sort() */
            @Override
            public int compare(File o1, File o2) {
                if ((o1.head).equals(o2.head)) { 	// HEAD 부분이 같다면 
                    return o1.number-o2.number; 	// NUMBER 오름차순 정렬
                }else{
                    return (o1.head).compareTo(o2.head); // HEAD 부분을 기준으로 사전 순 정렬
                }
            }
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = file_info[i].file_name;
        }
        
        return answer;
    }

    // file name을 head, number, tail로 나누는 함수
    public static String[] splitFileName(String file){ 
        String str[] = new String[3];
        str[0] = ""; // HEAD
        str[1] = ""; // NUMBER
        str[2] = ""; // TAIL

        int idx = 0;
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);

            if(idx==0 && !Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==0 && Character.isDigit(c)){
                idx ++;
            }

            if(idx==1 && Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==1 && !Character.isDigit(c)){
                idx ++;
            }
            str[idx] += c;
        }

        str[0] = str[0].toLowerCase(); 
        /*HEAD의 경우 대소문자 구분이 없으므로 전부 소문자로 변경 */
        return str;
    
    }
	

}
