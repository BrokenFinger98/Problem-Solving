import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][2];
        dp = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            matrix[i][0] = r;
            matrix[i][1] = c;
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(go(1, N));
    }
    static int go(int start, int end){
        if(start == end) return 0;
        if(dp[start][end] == Integer.MAX_VALUE){
            int min = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                min = Math.min(min, go(start, i) + go(i+1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1]);
            }
            dp[start][end] = Math.min(dp[start][end], min);
        }
        return dp[start][end];
    }
}