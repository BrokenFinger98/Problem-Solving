import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			map1.put(s, i + 1);
			map2.put(i + 1, s);
		}

		for (int i = 0; i < M; ++i) {
			String s = br.readLine();
			if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
				int index = Integer.parseInt(s);
				sb.append(map2.get(index) + "\n");
			} else
				sb.append(map1.get(s) + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}