import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if(stack.isEmpty() || prices[stack.peek()] <= prices[i]) {
                stack.push(i);
            }else{
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int index = stack.pop();
                    answer[index] = i - index;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }
        return answer;
    }
}