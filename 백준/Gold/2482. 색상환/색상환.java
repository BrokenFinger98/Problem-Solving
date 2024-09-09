import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(N, K));

    }
    static int recur(int num, int count){
        if(count == 1) return num;
        if(num <= 0 || num < 2 * count) return 0;
        if(dp[num][count] == -1) dp[num][count] = (recur(num-2, count-1) + recur(num-1, count))%1000000003;
        return dp[num][count];
    }
}
