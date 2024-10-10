import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static long n;
    static final int mod = 1_500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        n %= mod;
        dp = new int[(int) (n+1)];
        Arrays.fill(dp, -1);
        System.out.println(fibo((int)n));
        br.close();
    }
    static int fibo(int n){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = (fibo(n-1)+ fibo(n-2))%1_000_000;
        return dp[n];
    }
}

