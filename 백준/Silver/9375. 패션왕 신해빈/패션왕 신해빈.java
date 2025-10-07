import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
			int count = 1;
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				count *= entry.getValue() + 1;
			}
			sb.append(--count).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}