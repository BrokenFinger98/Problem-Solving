import java.io.*;
import java.util.*;

public class Main {
	private static class Node {
		int u, weight;

		public Node(int u, int weight){
			this.u = u;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		List<Node>[] nodes = new List[V+1];
		int[] dist = new int[V + 1];
		for(int i = 1; i <= V; ++i) {
			dist[i] = Integer.MAX_VALUE;
			nodes[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; ++i){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Node node = new Node(to, weight);
			nodes[from].add(node);
		}

		dijkstra(start, dist, nodes);

		for(int i = 1; i <= V; ++i){
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}

		br.close();
	}

	private static void dijkstra(int start, int[] dist, List<Node>[] nodes) {
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int here = now.u;
			int here_dist = now.weight;
			if(dist[here] != here_dist) continue;
			for(Node node : nodes[here]) {
				int to = node.u;
				int weight = node.weight;
				if (dist[to] > dist[here] + weight) {
					dist[to] = dist[here] + weight;
					pq.offer(new Node(to, dist[to]));
				}
			}
		}
	}
}