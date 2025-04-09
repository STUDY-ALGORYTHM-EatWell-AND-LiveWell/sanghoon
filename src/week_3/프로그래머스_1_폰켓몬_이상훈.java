package week_3;
import java.util.*;

public class 프로그래머스_1_폰켓몬_이상훈 {
    class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums)
                set.add(num);
            return Math.min(nums.length/2, set.size());
        }
    }
}
