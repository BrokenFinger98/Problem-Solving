
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();
        
        Map<String, Integer> gemCount = new HashMap<>();
        
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        for (int right = 0; right < gems.length; right++) {
            String rightGem = gems[right];
            gemCount.put(rightGem, gemCount.getOrDefault(rightGem, 0) + 1);
            
            while (gemCount.size() == totalTypes) {
                int currentLength = right - left + 1;
                
                if (currentLength < minLength) {
                    minLength = currentLength;
                    result[0] = left + 1;
                    result[1] = right + 1;
                }                

                String leftGem = gems[left];
                gemCount.put(leftGem, gemCount.get(leftGem) - 1);
                
                if (gemCount.get(leftGem) == 0) {
                    gemCount.remove(leftGem);
                }
                
                left++;
            }
        }
        
        return result;
    }
}