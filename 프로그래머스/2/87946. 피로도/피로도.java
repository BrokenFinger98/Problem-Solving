import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] used = new boolean[dungeons.length];
        dfs(k, dungeons, used, 0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, boolean[] used, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (used[i]) continue;
            int req = dungeons[i][0], cost = dungeons[i][1];
            if (k < req) continue;    

            used[i] = true;
            dfs(k - cost, dungeons, used, depth + 1);
            used[i] = false;
        }
    }
}