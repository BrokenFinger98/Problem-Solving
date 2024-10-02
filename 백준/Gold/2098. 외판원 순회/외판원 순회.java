import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = 16*1_000_000;
    static int[][] weights;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        weights = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                weights[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 16*1_000_000);
        }

//        for (int i = 0; i < N; i++) {
//            int flag = 1 << i;
//            dp[i][flag] = go(i, i, flag);
//            System.out.println(dp[i][flag]);
//            answer = Math.min(answer, dp[i][flag]);
//        }
        System.out.println(go(0, 0, 1));
        br.close();
    }
    static int go(int start, int cur, int flag){
        if(flag == Math.pow(2, N)-1){
            return weights[cur][start] == 0 ? 1_000_000 : weights[cur][start];
        }
        if(dp[cur][flag] != 16*1_000_000) return dp[cur][flag];
        for (int i = 0; i < N; i++) {
            if((flag & 1 << i) != 0) continue;
            if(weights[cur][i] == 0) continue;
            dp[cur][flag] = Math.min(dp[cur][flag], go(start, i, flag | 1 << i) + weights[cur][i]);
        }
        return dp[cur][flag];
    }
}

