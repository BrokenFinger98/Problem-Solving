import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	private static class Node implements Comparable<Node>{
		int from;
		int to;
		int distance;
		
		public Node(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	private static long k;
	private static ArrayList<Node> list = new ArrayList<>();
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		
		parent = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parent[i] = i-1;
		}
		parent[1] = n;
		
		st = new StringTokenizer(br.readLine());
		for (int i =0 ; i < n; i++) {
			int dis = Integer.parseInt(st.nextToken());
			list.add(new Node(0, i+1, dis));
		}
		
		boolean[] isConstruct = new boolean[n+1];
		for (int i = 0; i < m; i++) {// 공사 구간 체크하기
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			if (start == 1 && end == n) {
				parent[1] = 1;
				continue;
			}
			parent[end] = end;
		}
		
//		for (int i = 1; i < n+1; i++) {
//			if (!isConstruct[i]) {//공사중이 아닌 인접해 있는 동이라면
//				if (i == n) {
//					list.add(new Node(i, 1, 0));
//				} else {
//					list.add(new Node(i, i+1, 0));
//				}
//			}
//		}
		
		if (m <= 1) {
			System.out.println("YES");
		} else {
			Collections.sort(list);
			long minPrice = dijkstra();
//		System.out.println(minPrice);
			if (minPrice > k) {
				System.out.println("NO");
			} else { 
				System.out.println("YES");
			}
		}
	}
	
	public static long dijkstra() {
		long price = 0;
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			
			int a = node.from;
			int b = node.to;
			int distance = node.distance;
//			System.out.println(a + " " + b + " " + distance);
			if (findParent(a) != findParent(b)) {
//				System.out.println(a + " " + b + " " + distance);
				unionParent(a, b);
				price += distance;
			}
		}
		return price;
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static int findParent(int a) {
		if (parent[a] == a) return a;
		else return parent[a] = findParent(parent[a]);
	}
}
