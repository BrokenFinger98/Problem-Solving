import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        recur(N);
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[N]);
        }
        System.out.println(answer);
    }
    static int recur(int num){
        if(num == 1){
            return 0;
        }
        if(dp[num] == 0){
            int result = Integer.MAX_VALUE;
            if(num%3 == 0)
                result = Math.min(result, recur(num/3) + 1);
            if(num % 2 == 0)
                result = Math.min(result, recur(num/2) + 1);
            result = Math.min(result, recur(num-1) + 1);
            dp[num] = result;
        }
        return dp[num];
    }
}
