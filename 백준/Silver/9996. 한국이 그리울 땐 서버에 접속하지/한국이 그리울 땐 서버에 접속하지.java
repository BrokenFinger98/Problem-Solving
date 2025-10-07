import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String start = st.nextToken();
		String end = st.nextToken();

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			if (str.length() < start.length() + end.length()) {
				sb.append("NE" + "\n");
			}else {
				if (str.startsWith(start) && str.endsWith(end)) {
					sb.append("DA" + "\n");
				} else
					sb.append("NE" + "\n");
			}
		}

		System.out.print(sb);
		br.close();
	}
}