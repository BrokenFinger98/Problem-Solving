import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static class God{
        int x, y;

        public God(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, from, to;
    static double weight, answer;
    static God[] gods;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gods = new God[N];
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gods[i] = new God(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            if(find(from) != find(to)){
                union(from, to);
            }
        }

        for (int i = 0; i < N; i++) {
            int fromX = gods[i].x;
            int fromY = gods[i].y;
            for (int j = i+1; j < N; j++) {
                int toX = gods[j].x;
                int toY = gods[j].y;
                weight = Math.sqrt(Math.pow(fromX - toX, 2) + Math.pow(fromY - toY, 2));
                pq.offer(new Edge(i+1, j+1, weight));
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            from = edge.from;
            to = edge.to;
            weight = edge.weight;
            if(find(from) != find(to)){
                union(from, to);
                answer += weight;
            }
        }

        System.out.println(String.format("%.2f", answer));
    }
    static void union(int v, int u){
        int pv = find(v);
        int pu = find(u);
        if(pv < pu)
            parents[pu] = pv;
        else
            parents[pv] = pu;
    }

    static int find(int v){
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
}
