import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

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

    static int N, M, answer, from, to, weight;
    static int[] parents;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(from, to, weight));
        }

        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            from = edge.from;
            to = edge.to;
            weight = edge.weight;
            if (find(from) != find(to)){
                union(from, to);
                answer += weight;
            }
        }

        System.out.println(answer);
    }
    static void union(int v, int u){
        int pv = find(v);
        int pu = find(u);
        if (pv < pu) parents[pu] = pv;
        else parents[pv] = pu;
    }
    static int find(int v){
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
}
