import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static class Thing implements Comparable<Thing>{
		int w;
		int v;
		public Thing(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		
		public int compareTo(Thing o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Thing[] things = new Thing[n];
		int[] weight = new int[100001];
		long[][] dp = new long[n][k+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			things[i] = new Thing(w, v);
			weight[w] = v;
		}
		
		Arrays.sort(things);
		
		long max = 0;
		for (int j = 1; j < k + 1; j++) {
			if (j < things[0].w)
				continue;
			dp[0][j] = things[0].v;
			max = things[0].v;
		}
		
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < k+1; j++) {
				if (j >= things[i].w) {
					dp[i][j] = Math.max(dp[i-1][j], things[i].v + dp[i-1][j - things[i].w]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
				max = Math.max(max, dp[i][j]);
			}
		}
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 1; j < k+1; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(max);
	}

}
