import java.util.*;

class Solution {
    List<Integer>[] tree;
    int[][] dp;
    int[] sales;

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        this.sales = sales;
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] link : links) {
            tree[link[0]].add(link[1]);
        }

        dp = new int[n + 1][2];
        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int cur) {
        dp[cur][1] = sales[cur - 1]; 

        if (tree[cur].isEmpty()) {
            dp[cur][0] = 0;
            return;
        }

        int extra = Integer.MAX_VALUE; 
        int sumIfINotAttend = 0;

        for (int child : tree[cur]) {
            dfs(child);

            dp[cur][1] += Math.min(dp[child][0], dp[child][1]);

            if (dp[child][0] < dp[child][1]) {
                sumIfINotAttend += dp[child][0];
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            } else {
                sumIfINotAttend += dp[child][1];
                extra = 0; 
            }
        }

        dp[cur][0] = sumIfINotAttend + extra;
    }
}