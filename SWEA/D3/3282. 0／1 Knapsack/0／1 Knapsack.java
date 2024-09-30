import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, K;
    static int[] dp;
    static int[] v;
    static int[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            v = new int[N];
            c = new int[N];
            dp = new int[K+1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                for (int j = K; j >= v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + c[i]);
                }
            }
            sb.append("#").append(t).append(" ").append(dp[K]);
            System.out.println(sb.toString());
        }
        br.close();
    }
}
