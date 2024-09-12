import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n+1];
        dp = new int[k+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= k; i++) {
            int ret = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (i >= coins[j]) {
                    if(dp[i-coins[j]] == Integer.MAX_VALUE) continue;
                    ret = Math.min(ret, dp[i-coins[j]]+1);
                }
            }
            dp[i] = ret;
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}

