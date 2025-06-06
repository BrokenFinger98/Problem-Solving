import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] array : clothes){
            map.put(array[1], map.getOrDefault(array[1], 0) + 1);
        }
        
        int answer = 1;
        for(Integer value : map.values()){
            answer *= value + 1;
        }
        return answer - 1;
    }
}