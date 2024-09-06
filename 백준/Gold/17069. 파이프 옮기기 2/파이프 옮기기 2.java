import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static boolean[][] map;
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];

        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("0");
            }
        }
        dp = new long[N][N][3];
        for (int i = 1; i < N; i++) {
            if(!map[0][i]) break;
            dp[0][i][0] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if(!map[i][j]) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                if(!map[i-1][j] || !map[i][j-1]) continue;
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
        br.close();
    }
}
