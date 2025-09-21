import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] list = new List[n + 1];
        int[] cost = new int[n + 1];
        Arrays.fill(cost , -1);

        for(int i = 1; i <= n; ++i){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < roads.length; ++i){
            int from = roads[i][0];
            int to = roads[i][1];
            list[from].add(to);
            list[to].add(from);
        }
        
        bfs(destination, cost, list);
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; ++i){
            answer[i] = cost[sources[i]];
        }
        
        return answer;
    }
    
    private void bfs(int start, int[] cost, List<Integer>[] list){
        cost[start] = 0;
        boolean visited[] = new boolean[cost.length];
        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Integer next : list[now]){
                if(visited[next]) continue;
                visited[next] = true;
                cost[next] = cost[now] + 1;
                queue.offer(next);
            }
        }
    }
}