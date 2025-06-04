import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : participant) {
            Integer value = map.get(str);
            if(value != null){
                map.put(str, value + 1);
            }else {
                map.put(str, 1);
            }
        }
        for(String str : completion){
            Integer value = map.get(str);
            if(value != 1){
                map.put(str, value - 1);
            }else { 
                map.remove(str);
            }
        }
        for(String str : map.keySet()){
            return str;
        }
        return null;
    }
}