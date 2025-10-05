import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String answer = "";
		for (int i = 0; i < s.length(); ++i) {
			if('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
				answer += (char)((s.charAt(i) - 'a' + 13) % 26 + 'a');
			}else if('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
				answer += (char)((s.charAt(i) - 'A' + 13) % 26 + 'A');
			}else answer += s.charAt(i);
		}
		System.out.println(answer);
		br.close();
	}
}