import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder left = new StringBuilder();

		int[] arr = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			arr[s.charAt(i) - 'A']++;
		}

		int oddCount = 0;
		int oddIndex = -1;
		for (int i = 0; i < 26; ++i) {
			if (arr[i] % 2 == 1) {
				++oddCount;
				oddIndex = i;
			}
		}

		if(oddCount > 1){
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		for (int i = 0; i < 26; ++i) {
			for (int j = 0; j < arr[i] / 2; ++j) {
				left.append((char)('A' + i));
			}
		}

		StringBuilder answer = new StringBuilder();
		answer.append(left);
		if(oddIndex != -1)
			answer.append((char)('A' + oddIndex));
		answer.append(new StringBuilder(left).reverse());
		System.out.println(answer);
		br.close();
	}
}