package ju;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {  
  public static void main(String args[]) throws IOException{ 
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();//몇개의 단어인지 정수를 입력받음
    String[] s = new String[N]; 
    
    sc.nextLine();

    for(int i=0;i<N;i++){
      s[i]=sc.nextLine();
    }
  Arrays.sort(s,new Comparator<String>(){ //임시 클래스를 선언
    public int compare(String s1,String s2){
      if(s1.length()==s2.length()){
        //단어의 길이가 같을 경우
        return s1.compareTo(s2);//아스키코드값으로비교 s1>s2 :1,s1<s2 :-1
      } else {
        //단어의 길이가 다를 경우
        return s1.length()-s2.length();//s1>s2 : 양수
      //양수가 반환되면 위치가 서로 바뀌게 되고,음수가 반환되면 위치가 바뀌지않는다.
      }
    }
  });
    System.out.println(s[0]);
    for(int i=1;i<N;i++){
      if(!s[i].equals(s[i-1])){//앞단어와 중복된 경우 이 단어는 출력x
        System.out.println(s[i]);
      }
    }
    sc.close();
    
    
    
  } 
}
