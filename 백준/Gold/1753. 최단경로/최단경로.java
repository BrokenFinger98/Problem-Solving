import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	private static final int INF = (int)1e9;
	private static int[] d;
	private static ArrayList<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		d = new int[v+1];
		Arrays.fill(d, INF);
		
		for (int i = 0; i < v+1; i++) {
			list.add(new ArrayList<>());
		}
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new int[] {to, dis});
		}
		
		dijkstra(k);
		
		for (int i = 1; i < v+1; i++) {
			if (d[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(d[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		pq.add(new int[] {start, 0});
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			
			int now = p[0];
			int dis = p[1];
			
			if (d[now] < dis) continue;
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int cost = dis + list.get(now).get(i)[1];
				
				if (cost < d[list.get(now).get(i)[0]]) {
					d[list.get(now).get(i)[0]] = cost;
					pq.add(new int[] {list.get(now).get(i)[0], cost});
				}
			}
		}
	}

}
