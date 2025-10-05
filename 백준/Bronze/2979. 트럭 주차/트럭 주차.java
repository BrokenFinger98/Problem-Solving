import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] prefix = new int[101];
		int sum = 0;
		for (int i = 0; i < 3; ++i){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int j = start; j < end; ++j) {
				prefix[j]++;
			}
		}

		for (int i = 1; i < 101; ++i) {
			if(prefix[i] == 1){
				sum += A;
			}else if(prefix[i] == 2){
				sum += B * 2;
			}else if(prefix[i] == 3)
				sum += C * 3;
		}
		System.out.println(sum);
		br.close();
	}
}