import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int n, m, k, a, b, c;
    static List<Node>[] adj;
    static PriorityQueue<Integer>[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        dist = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>(Comparator.reverseOrder());
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
        }

        dist[1].offer(0);
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : adj[now.to]) {
                if (dist[next.to].size() < k) {
                    dist[next.to].offer(now.weight + next.weight);
                    pq.offer(new Node(next.to, now.weight + next.weight));
                } else if (dist[next.to].peek() > now.weight + next.weight) {
                    dist[next.to].offer(now.weight + next.weight);
                    dist[next.to].poll();
                    pq.offer(new Node(next.to, now.weight + next.weight));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(dist[i].size() == k ? dist[i].peek() : -1).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

