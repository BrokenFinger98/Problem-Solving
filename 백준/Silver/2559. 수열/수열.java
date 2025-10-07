import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int MAX_SUM = -1 * 100_000 * 100;
		int[] prefix = new int[N + 1];
		prefix[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - K + 1; ++i) {
			MAX_SUM = Math.max(MAX_SUM, prefix[i + K] - prefix[i]);
		}
		System.out.println(MAX_SUM);
		br.close();
	}
}