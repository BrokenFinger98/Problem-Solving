import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, M, from, to, weight, start, end, answer;
    static List<Node>[] adj;
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new List[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            adj[from].add(new Node(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int here = now.to;
            int here_dist = now.weight;
            if (dist[here] != here_dist) {
                continue;
            }
            for (Node node : adj[here]) {
                to = node.to;
                weight = node.weight;
                if(dist[to] > dist[here] + weight){
                    dist[to] = dist[here] + weight;
                    pq.offer(new Node(to, dist[to]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
