package week6.woojin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    Site : Programmers Algorithm site
    title : 폰켓몬
    number : 1845
    subject : Set(굳이 Set 안써도 되긴 할듯 배열해서 중복 제거 해도 됨)
    difficulty : silver 4
 */

public class PrG1845 {
    public int solution(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(nums[i]);
        }
        return Math.min(size / 2, set.size());
    }
}
