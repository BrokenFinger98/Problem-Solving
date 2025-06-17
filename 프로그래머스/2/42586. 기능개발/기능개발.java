import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; ++i){
            queue.offer(new int[]{progresses[i], speeds[i]});
        }
        
        while(!queue.isEmpty()){
            int[] task = queue.poll();
            int progress = task[0];
            int speed = task[1];
            int day = 0;
            day += (100 - progress)/speed;
            if((100 - progress)%speed != 0) day++;
            int result = 1;
            
            while(!queue.isEmpty()){
                int[] nextTask = queue.peek();
                int nextProgress = nextTask[0];
                int nextSpeed = nextTask[1];
                int nextDay = 0;
                nextDay += (100 - nextProgress)/nextSpeed;
                if((100 - nextProgress)%nextSpeed != 0) nextDay++;   
                if(day >= nextDay){
                    queue.remove();
                    ++result;
                }else{
                    break;
                }
            }
            list.add(result);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}