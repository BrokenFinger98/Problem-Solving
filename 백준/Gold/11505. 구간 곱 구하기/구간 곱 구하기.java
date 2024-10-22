import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int n;
	private static int[] arr;
	private static long[] mulTree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mulTree = new long[4*n];
		makeTree(1, 0, n - 1);
		
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int query = Integer.parseInt(st.nextToken());
			
			if (query == 1) {
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken());
				update(1, 0, n-1, left, right);
			} else {
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;
				
				long answer = getMul(1, 0, n-1, left, right);
				sb.append(answer + "\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void makeTree(int idx, int s, int e) {
		if (s == e) {
			mulTree[idx] = arr[s];
			return;
		}
		
		int mid = (s + e) / 2;
		
		makeTree(2 * idx, s, mid);
		makeTree(2 * idx + 1, mid + 1, e);
		
		mulTree[idx] = ((mulTree[2 * idx] % 1_000_000_007) * (mulTree[2 * idx + 1] % 1_000_000_007)) % 1_000_000_007;
	}
	
	public static void update(int idx, int ts, int te, int target, int value) {
		if (target < ts || target > te) {
			return;
		}
		
		if (ts == te) {
			mulTree[idx] = value;
			return;
		}
		
		int mid = (ts + te) / 2;
		
		update(2 * idx, ts, mid, target, value);
		update(2 * idx + 1, mid + 1, te, target, value);
		
		mulTree[idx] = ((mulTree[2 * idx] % 1_000_000_007) * (mulTree[2 * idx + 1] % 1_000_000_007)) % 1_000_000_007;
	}
	
	public static long getMul(int idx, int s, int e, int ts, int te) {
		if (s > te || e < ts) return 1;
		else if (ts <= s && e <= te) return mulTree[idx];
		
		int mid = (s + e) / 2;
		
		long left = getMul(2 * idx, s, mid, ts, te);
		long right = getMul(2 * idx + 1, mid + 1, e, ts, te);
		
		return ((left%1_000_000_007) * (right%1_000_000_007)) % 1_000_000_007;
	}
}
