import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[] m;
    static int[] c;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N+1];
        c = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][10001];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if(i == 1){
                    if(j >= c[i]) dp[i][j] = m[i];
                }else{
                    if(j >= c[i]) dp[i][j] = Math.max(dp[i-1][j-c[i]] + m[i], dp[i-1][j]);
                    else dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}