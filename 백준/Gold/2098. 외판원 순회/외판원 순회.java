import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[][] arr, dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][1<<n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 16*1_000_000);
		}
		
		System.out.println(backTracking(0, 1));	
		
	}
	
	public static int backTracking(int curNode, int bit) {
		if (bit == (1<<n) - 1) {
			if (arr[curNode][0] == 0) return 1_000_000;
			return arr[curNode][0];
		}
		
		if(dp[curNode][bit]!= 16_000_000) return dp[curNode][bit];
		
		for (int i = 1; i < n; i++) {
			if (arr[curNode][i] == 0) continue;
			if ((bit & (1 << i)) != 0) continue;
			dp[curNode][bit] = Math.min(dp[curNode][bit], backTracking(i, bit | (1 << i)) + arr[curNode][i]);
		}
		return dp[curNode][bit];
	}

}
