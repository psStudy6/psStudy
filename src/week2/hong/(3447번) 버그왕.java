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

// ================================================================================== //

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        
        // CheckPoint1. 해당 데이터 반복을 통해서 문자 기입
        while(in.hasNextLine()){
            String X = in.nextLine();
            System.out.println(main.solution(X));
        }
    }
    
    // CheckPoint2. BUG라는 단어가 있을 경우 삭제 시키는 반복문
    public String solution(String X){
        while(X.indexOf("BUG") >= 0){ X = X.replace("BUG", ""); }
        return X;
    }
}
