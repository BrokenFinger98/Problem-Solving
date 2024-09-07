import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp = new long[91];
    static long ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
        br.close();
    }
    static long fibo(int index){
    	if(index <= 1) return dp[index] = index;
        if(dp[index] == 0) dp[index] = fibo(index-1) + fibo(index-2);
        return dp[index];
    }
}