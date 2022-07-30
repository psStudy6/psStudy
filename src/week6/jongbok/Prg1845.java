import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int total = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        
        if(map.size() < (total/2)){
            answer = map.size();
        }else{
            answer = (total/2);
        }
        
        
        return answer;
    }
}
