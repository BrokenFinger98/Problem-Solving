import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        int size = set.size();
        int result = size >= nums.length/2 ? nums.length/2 : size;
        return result;
    }
}