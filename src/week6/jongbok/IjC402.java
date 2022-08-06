import java.util.*;

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      HashMap<Character, Integer> map1 = new HashMap<>();
      HashMap<Character, Integer> map2 = new HashMap<>();
      
      String str1 = sc.next();
      String str2 = sc.next();
      
      for(int i=0; i<str1.length(); i++){
          char c = str1.charAt(i);
          if(map1.containsKey(c)){
              map1.put(c, map1.get(c)+1);
          }else{
              map1.put(c, 1);
          }
      }
      
      for(int i=0; i<str2.length(); i++){
          char c = str2.charAt(i);
          if(map2.containsKey(c)){
              map2.put(c, map2.get(c)+1);
          }else{
              map2.put(c, 1);
          }
      }
      
      
      for(Character c: map1.keySet()){
          if(map2.containsKey(c)){
              
              if(map1.get(c) == map2.get(c)){
                  continue;
              }else{
                  System.out.println("NO");
                  return; 
              }
              
          }else{
              System.out.println("NO");
              return; 
          }
      }
      
      
      System.out.println("YES"); 
      
      
      
      
    }
}
