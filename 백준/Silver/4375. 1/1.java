import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;

		while ((s = br.readLine()) != null) {
			int n = Integer.parseInt(s.trim());
			int count = 1;
			int ret = 1 % n;
			while (ret != 0) {
				ret = (ret * 10 + 1) % n;
				count++;
			}

			sb.append(count).append("\n");
		}

		System.out.print(sb);
		br.close();
	}
}