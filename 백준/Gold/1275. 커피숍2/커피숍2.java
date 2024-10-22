import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[] arr;
	private static long[] sumTree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sumTree = new long[4 * n];
		makeTree(1, 0, n - 1);
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
            if (left > right) {
				int temp = left;
				left = right;
				right = temp;
			}
			sb.append(getSum(1, 0, n - 1, left, right) + "\n");
			int target = Integer.parseInt(st.nextToken())-1;
			int value = Integer.parseInt(st.nextToken());
			update(1, 0, n - 1, target, value);
		}
		System.out.println(sb);
	}
	
	public static void makeTree(int node, int s, int e) {
		if (s == e) {
			sumTree[node] = arr[s];
			return;
		}
		
		int mid = (s + e) / 2;
		
		makeTree(2 * node, s, mid);
		makeTree(2 * node + 1, mid + 1, e);
		
		sumTree[node] = sumTree[2 * node] + sumTree[2 * node + 1];
	}
	
	public static void update(int node, int s, int e, int target, int value) {
		if (s > target || e < target) return;
		
		if (s == e) {
			sumTree[node] = value;
			return;
		}
		
		int mid = (s + e) / 2;
		
		update(2 * node, s, mid, target, value);
		update(2 * node + 1, mid + 1, e, target, value);
		
		sumTree[node] = sumTree[2 * node] + sumTree[2 * node + 1];
	}
	
	public static long getSum(int node, int s, int e, int ts, int te) {
		if (s > te || e < ts) return 0;
		else if (ts <= s && e <= te) return sumTree[node];
		
		int mid = (s + e) / 2;
		
		long left = getSum(2 * node, s, mid, ts, te);
		long right = getSum(2 * node + 1, mid + 1, e, ts, te);
		
		return left + right;
	}

}
