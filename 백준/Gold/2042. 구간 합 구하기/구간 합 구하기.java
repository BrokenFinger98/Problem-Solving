import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static long[] arr, tree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[4*arr.length];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		//세그먼트 트리 합 구하기
		int start = 0;
		int end = arr.length-1;
		makeTree(start, end, 1);
		
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {//b번째 수를 c로 바꾸기
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long saveNum = arr[b-1];
				arr[b-1] = c;
				updateTree(start, end, 1, b-1, c - saveNum);
			} else {//b에서 c까지의 합 구하기
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long sum = sum(start, end, 1, b-1, c-1);
				System.out.println(sum);
			}
		}
	}
	
	private static long makeTree(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end) / 2;
		return tree[node] = makeTree(start, mid, node*2) + makeTree(mid+1, end, node*2 + 1);
	}
	
	private static void updateTree(int start, int end, int node, long index, long dif) {
		if (index < start || index > end) return;
		tree[node] += dif;
		if (start == end) return;
		int mid = (start + end) / 2;
		updateTree(start, mid, node*2, index, dif);
		updateTree(mid+1, end, node*2+1, index, dif);
	}
	
	private static long sum(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return 0;
		if (left <= start && end <= right) return tree[node];
		int mid = (start+end) / 2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2 + 1, left, right);
	}

}
