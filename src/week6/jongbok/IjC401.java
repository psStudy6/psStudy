import java.util.*;

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      String str = sc.next();
      int maxCnt = Integer.MIN_VALUE;
      String answer = "";
      
      HashMap<Character, Integer> map = new HashMap<>();
      
      for(int i=0; i<str.length(); i++){
          char c = str.charAt(i);
          
          if(map.containsKey(c)){
              map.put(c, map.get(c)+1);
          }else{
              map.put(c, 1);
          }
      }
      
      for(Character c: map.keySet()){
          if(maxCnt < map.get(c)){
              maxCnt = map.get(c);
              answer = Character.toString(c);
          }
      }
      
      System.out.println(answer);     
      
    }
}
