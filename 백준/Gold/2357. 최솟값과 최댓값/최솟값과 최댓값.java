import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int n;
	private static int[] arr, maxTree, minTree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		maxTree = new int[4 * n];
		minTree = new int[4 * n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		makeTree(1, 0, n - 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
			
			int max = getMax(1, 0, n-1, left, right);
			int min = getMin(1, 0, n-1, left, right);
			
			sb.append(min + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	public static void makeTree(int node, int nodeLeft, int nodeRight) {
		if (nodeLeft == nodeRight) {
			maxTree[node] = arr[nodeLeft];
			minTree[node] = arr[nodeLeft];
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		
		makeTree(2 * node, nodeLeft, mid);
		makeTree(2 * node + 1, mid + 1, nodeRight);
		
		maxTree[node] = Math.max(maxTree[2 * node], maxTree[2 * node + 1]);
		minTree[node] = Math.min(minTree[2 * node], minTree[2 * node + 1]);
	}
	
	public static int getMax(int node, int s, int e, int ts, int te) {
		if (s > te || e < ts) return 1;
		else if (ts <= s && e <= te) return maxTree[node];
		
		int mid = (s + e) / 2;
		
		int left = getMax(2 * node, s, mid, ts, te);
		int right = getMax(2 * node + 1, mid + 1, e, ts, te);
		
		return Math.max(left, right);
	}
	
	public static int getMin(int node, int s ,int e, int ts, int te) {
		if (s > te || e < ts) return 1_000_000_001;
		else if (ts <= s && e <= te) return minTree[node];
		
		int mid = (s + e) / 2;
		
		int left = getMin(2 * node , s, mid, ts, te);
		int right = getMin(2 * node + 1, mid + 1, e, ts, te);
		
		return Math.min(left, right);
	}
}
