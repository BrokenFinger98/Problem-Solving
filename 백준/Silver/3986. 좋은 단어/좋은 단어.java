import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < N; ++i) {
			ArrayDeque<Character> stack = new ArrayDeque<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); ++j) {
				char c = s.charAt(j);
				if (!stack.isEmpty() && c == stack.peek()) {
					stack.pop();
				}else
					stack.push(c);
			}
			if(stack.isEmpty()) ++count;
		}

		System.out.println(count);
		br.close();
	}
}