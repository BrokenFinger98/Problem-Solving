import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int weight;
    int u;

    public Node(int weight, int u) {
        this.weight = weight;
        this.u = u;
    }
}
public class Main {
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
        return o1.weight - o2.weight;
    });
    static List<Node>[] graph;
    static int[] dist;
    static int V, E, K;
    static int from, to, weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        graph = new List[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < V+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(weight, to));
        }
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
        br.close();
    }

    static void dijkstra(int start) {
        dist[start] = 0;
        priorityQueue.offer(new Node(0, start));
        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();
            int here = now.u;
            int here_dist = now.weight;
            if(dist[here] != here_dist) continue;
            for (Node node : graph[here]) {
                int to = node.u;
                int weight = node.weight;
                if (dist[to] > dist[here] + weight) {
                    dist[to] = dist[here] + weight;
                    priorityQueue.offer(new Node(dist[to], to));
                }
            }
        }
    }
}
