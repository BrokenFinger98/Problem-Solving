import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    static int X;
    static int[] dp;
    static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        X = Integer.parseInt(br.readLine());
        dp = new int[X+1];
        before = new int[X+1];
        Arrays.fill(dp, 100001);
        dp[1] = 0;
        for(int i = 2; i <= X; ++i){
            dp[i] = dp[i-1] + 1;
            before[i] = i - 1;
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
        }
        sb.append(dp[X]).append("\n");
        while (X > 0){
            sb.append(X).append(" ");
            X = before[X];
        }
        System.out.println(sb);
        br.close();
    }
}

