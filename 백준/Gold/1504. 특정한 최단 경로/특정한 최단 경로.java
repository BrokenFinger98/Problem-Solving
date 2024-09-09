import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, E, a, b, c;
    static int v1, v2;
    static int[][] dist;
    static List<Node>[] adj;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[3][N+1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dijkstra(0, 1);
        dijkstra(1, N);
        dijkstra(2, v1);
        if((dist[0][v1] == Integer.MAX_VALUE || dist[2][v2] == Integer.MAX_VALUE || dist[1][v2] == Integer.MAX_VALUE) && (dist[0][v2] == Integer.MAX_VALUE || dist[2][v2] == Integer.MAX_VALUE || dist[1][v1] == Integer.MAX_VALUE)){
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(Math.min(dist[0][v1] + dist[2][v2] + dist[1][v2], dist[0][v2] + dist[2][v2] + dist[1][v1]));
        br.close();
    }

    static void dijkstra(int index, int start) {
        dist[index][start] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[index][now.to] != now.weight) continue;
            for (Node next : adj[now.to]) {
                if (dist[index][next.to] > dist[index][now.to] + next.weight) {
                    dist[index][next.to] = dist[index][now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[index][next.to]));
                }
            }
        }
    }
}
