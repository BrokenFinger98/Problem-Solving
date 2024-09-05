import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[][] dp;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        tree = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = tree[0][0];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < i+1; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + tree[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + tree[i+1][j+1]);
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(dp[n-1][i], answer);
        }

        System.out.println(answer);
    }
}
