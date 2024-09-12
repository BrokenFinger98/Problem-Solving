import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static class Node implements Comparable<Node>{
        int coordinate;
        int index;

        public Node(int coordinate, int index) {
            this.coordinate = coordinate;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.coordinate, o.coordinate);
        }
    }
    static int[] parents;
    static Node[][] nodes;
    static int N, x, y, z;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int connectedCount;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        nodes = new Node[3][N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            nodes[0][i] = new Node(x, i);
            nodes[1][i] = new Node(y, i);
            nodes[2][i] = new Node(z, i);
        }
        for (int i = 0; i < 3; i++) {
            Arrays.sort(nodes[i]);
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < 3; j++) {
                int distance = nodes[j][i+1].coordinate - nodes[j][i].coordinate;
                int from = nodes[j][i].index;
                int to = nodes[j][i+1].index;
                pq.offer(new Edge(from, to, distance));
            }
        }

        connectedCount = 1;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;
            if(find(from) != find(to)){
                union(from, to);
                answer += weight;
                ++connectedCount;
            }
            if(connectedCount == N) break;
        }

        System.out.println(answer);
    }
    static int find(int v){
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
    static void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu < pv) parents[pv] = pu;
        else parents[pu] = pv;
    }
}

