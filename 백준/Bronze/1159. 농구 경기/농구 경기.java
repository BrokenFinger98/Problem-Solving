import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[26];

		for (int i = 0; i < n; ++i) {
			s = br.readLine();
			arr[s.charAt(0) - 'a']++;
		}

		for (int i = 0; i < 26; ++i) {
			if(arr[i] >= 5){
				sb.append((char)('a' + i));
			}
		}

		s = sb.toString();
		if(s.isEmpty()) System.out.println("PREDAJA");
		else System.out.println(sb);
		br.close();
	}
}