import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, answer = Integer.MAX_VALUE;
    static int[][] input;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            input = new int[2][N+1];
            dp = new int[2][N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                input[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                input[1][i] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = input[0][1];
            dp[1][1] = input[1][1];
            for (int i = 2; i < N+1; i++) {
                dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + input[0][i];
                dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + input[1][i];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
    static int recur(int index, int num){
        if(num <= 1){
            return dp[index][num] = input[index][num];
        }
        if(dp[index][num] == 0){
            if(index == 0){
                dp[index][num] = Math.max(recur(index+1, num-2), recur(index+1, num-1)) + input[index][num];
            }else{
                dp[index][num] = Math.max(recur(index-1, num-2), recur(index-1, num-1)) + input[index][num];
            }
        }
        return dp[index][num];
    }
}
