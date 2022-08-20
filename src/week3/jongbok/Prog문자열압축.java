import java.util.*; 

class Solution {
    public int solution(String s) {
        
       int answer = Integer.MAX_VALUE; 
       
       int len = s.length();
       int cutLen = 0;
       int pos = 0; 
       ArrayList<String> arr = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
           
       while(true){
           pos = 0;
           cutLen++;
           arr.clear();
           
           if(cutLen > len){
               break; 
           }
           
           while(true){
               
               if(pos >= len){
                   break;
               }
               
               int end = pos+cutLen;
               if(end >= len){
                   end = len;
               }
               
               String tmp = s.substring(pos, end);
               arr.add(tmp);
               pos += cutLen;
           }
           
           sb.setLength(0);
           int size = arr.size();
           int cnt = 1;
           
           for(int i=1; i<size; i++){
               if(arr.get(i-1).equals(arr.get(i))){
                   cnt++;
               }else{
                   if(cnt != 1){
                       sb.append(Integer.toString(cnt));
                   }
                   sb.append(arr.get(i-1));
                   cnt = 1; 
               }
           }
           
           if(cnt != 1){
               sb.append(Integer.toString(cnt));
               sb.append(arr.get(size-1));
           }else{
               sb.append(arr.get(size-1));
           }
           
           answer = Math.min(answer, sb.length());
       }
       
       return answer; 
    }
}
