/**
 * 등록 번호 : 3447번  
 * 등록 제목 : 버그왕
 * 현재 상태 : 완료 ✔️
 */

// 📄 상태에 대한 중요 상태 설명
// CheckPoint   - 포인트 구간에 대한 설명
// (수정)       - 현재 부족한 로직 수정
// 확인         - Test하기 위한 중간 consle 데이터 점검(System.out.println("필요한 데이터 출력")

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {

            while (s.contains("BUG")) {
                s = s.replaceAll("BUG", "");
            }

            sb.append(s + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
