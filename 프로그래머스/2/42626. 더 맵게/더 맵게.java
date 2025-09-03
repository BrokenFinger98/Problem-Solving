import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i : scoville) {
			pq.offer(i);
		}
		int answer = 0;
		while (pq.size() >= 1) {
			int a = pq.poll();
			if (a >= K) {
				return answer;
			}
            if(pq.size() >= 1){
                int b = pq.poll();
			    pq.offer(a + (b * 2));
                answer++;   
            }else return -1;
		}
		return -1;
	}
}