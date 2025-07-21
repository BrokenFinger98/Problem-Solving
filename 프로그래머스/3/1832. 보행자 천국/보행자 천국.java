class Solution {
    static final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = 1;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (cityMap[y][x] == 1) continue; 

                if (x > 0) {
                    if (cityMap[y][x - 1] == 2) {
                        dp[y][x][0] = dp[y][x - 1][0]; 
                    } else {
                        dp[y][x][0] = (dp[y][x - 1][0] + dp[y][x - 1][1]) % MOD;
                    }
                }

                if (y > 0) {
                    if (cityMap[y - 1][x] == 2) {
                        dp[y][x][1] = dp[y - 1][x][1];
                    } else {
                        dp[y][x][1] = (dp[y - 1][x][0] + dp[y - 1][x][1]) % MOD;
                    }
                }
            }
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}