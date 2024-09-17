import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시간 : 132ms, 메모리 : 46,864KB
 */
public class Main {
    static int N, T;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1];
            System.out.println(go(N));
        }
        br.close();
    }

    public static int go(int x) {

        if (x == 0) return 1;
        if (x == 1) return 1;
        if (x == 2) return 5;
        if (x == 3) return 11;
        if (dp[x] != 0) return dp[x];

        dp[x] = go(x - 1) + 4 * go(x - 2);

        for (int i = 3; x >= i; ++i) {
            if (i % 2 == 0) {
                dp[x] += 3 * go(x - i);
            }
            if (i % 2 != 0) {
                dp[x] += 2 * go(x - i);
            }
        }

        return dp[x];

    }
}