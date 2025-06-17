import java.util.*;

class Solution {
	public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
		for(int i = 0; i < priorities.length; i++){
			queue.offer(new int[]{priorities[i], i});
            priorityQueue.offer(priorities[i]);
		}

		int count = 0;
		while(!queue.isEmpty()){
			int[] value = queue.poll();
            
            if(value[0] == priorityQueue.peek()){
                count++;
                priorityQueue.poll();
                
                if(value[1] == location){
                    return count;
                }
            }else{
                queue.offer(value);   
            }
		}
		return count;
	}
}