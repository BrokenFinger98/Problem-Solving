import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String palindrome = "";
		for (int i = s.length() - 1; i >= 0; --i) {
			palindrome += s.charAt(i);
		}
		if(palindrome.equals(s)){
			System.out.println(1);
		}else System.out.println(0);
		br.close();
	}
}