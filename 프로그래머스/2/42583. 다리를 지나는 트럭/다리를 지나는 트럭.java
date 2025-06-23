import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int answer = 0;
        int nowWeight = 0;
        
        for(int truck_weight : truck_weights){
            queue.offer(truck_weight);
        }
        
        while(!queue.isEmpty()){
            answer++;
            
            if(!bridge.isEmpty() && bridge.peek()[0] == answer){
                nowWeight -= bridge.poll()[1];
            }
            
            int truck = queue.peek();
        
            if(bridge.size() < bridge_length && nowWeight + truck <= weight){
                queue.poll();
                bridge.offer(new int[]{bridge_length + answer, truck});
                nowWeight += truck;
            }
        }
        
        while(!bridge.isEmpty()){
            ++answer;
            if(bridge.peek()[0] == answer){
                bridge.poll();
            }
        }
        
        return answer;
    }
}