import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(mod(A, B, C));
		br.close();
	}

	private static int mod(int A, int B, int C) {
		if(B == 1) return  A % C;
		long result = mod(A, B / 2, C);
		result = (result * result) % C;
		if(B % 2 != 0) result = (result * A) % C;
		return (int) result;
	}
}