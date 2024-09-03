/*

2 ≤ N ≤ 3,000,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d

8 30 4 30
7
9
7
30
2
7
9
25

 */
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken())-1;
		
		int[] sushi = new int[N+k-1]; // 뒤에 앞에걸 복사해서 붙임.
		int[] counts = new int[3000];
		counts[c] = 1;
		int maxKind;
		
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine())-1;
		
		for (int i = 0; i < k-1; i++)
			sushi[N+i] = sushi[i];

		int kind = 1;
		for (int i = 0; i < k; i++)
			if(++counts[sushi[i]]==1) kind++;
		
		maxKind = kind;
		int start = 0, end = k-1;
		for (int i = 0; i < N-1; i++) {
			if(--counts[sushi[start++]]==0) kind--;
			if(++counts[sushi[++end]]==1) kind++;
			if(kind > maxKind) {
				maxKind = kind;
			}
		}
		System.out.println(maxKind);
	}

}
