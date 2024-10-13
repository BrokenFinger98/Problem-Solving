import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;
    static int[][] dp;
    static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        input = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = MAX;
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            dp = new int[N][3];
            
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[0][i] = input[0][i];
                } else {
                    dp[0][i] = MAX;
                }
            }
            
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + input[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + input[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + input[i][2];
            }
            
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    answer = Math.min(answer, dp[N - 1][lastColor]);
                }
            }
        }

        System.out.println(answer);
    }
}
