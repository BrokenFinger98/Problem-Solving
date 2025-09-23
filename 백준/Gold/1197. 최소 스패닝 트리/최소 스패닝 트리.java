import java.io.*;
import java.util.*;

public class Main {
	private static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		int[] parent = new int[V + 1];
		for(int i = 1; i <= V; ++i) parent[i] = i;

		for(int i = 0; i < E; ++i){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from, to, weight));
		}

		int weight = 0;
		while(!pq.isEmpty()){
			Edge now = pq.poll();
			if(find(now.from, parent) != find(now.to, parent)){
				union(now.from, now.to, parent);
				weight += now.weight;
			}
		}
		
		System.out.println(weight);
	}
	
	private static int find(int v, int[] parent){
		if(parent[v] == v) return  v;
		return parent[v] = find(parent[v], parent);
	}

	private static void union(int u, int v, int[] parent) {
		int pu = find(u, parent);
		int pv = find(v, parent);
		if(pu > pv) parent[pu] = pv;
		else parent[pv] = pu;
	}
}