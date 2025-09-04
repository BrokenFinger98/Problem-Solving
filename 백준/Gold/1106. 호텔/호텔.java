import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] cost = new int[N];
		int[] customer = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			customer[i] = Integer.parseInt(st.nextToken());
		}

		int INF = 100_001;
		int MAX_CUSTOMER = C + 100;
		int[] dp = new int[MAX_CUSTOMER + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int i = 1; i <= MAX_CUSTOMER; ++i) {
			for (int j = 0; j < N; ++j){
				if(i >= customer[j]) {
					dp[i] = Math.min(dp[i], dp[i - customer[j]] + cost[j]);
				}
			}
		}

		int answer = INF;
		for (int i = C; i <= MAX_CUSTOMER; ++i) {
			answer = Math.min(answer, dp[i]);
		}

		System.out.println(sb.append(answer));
	}
}