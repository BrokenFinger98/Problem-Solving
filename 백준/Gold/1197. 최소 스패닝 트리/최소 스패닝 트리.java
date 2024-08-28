import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int weight;
        int from;
        int to;

        public Edge(int weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
    static int V, E, from, weight, to, sum;
    static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        for (int i = 1; i < V + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            priorityQueue.offer(new Edge(weight, from, to));
        }

        while (!priorityQueue.isEmpty()) {
            Edge now = priorityQueue.poll();
            if (find(now.from) != find(now.to)) {
                union(now.from, now.to);
                sum += now.weight;
            }
        }

        System.out.println(sum);
    }
    static void union(int u, int v){
        int pu = parents[u];
        int pv = parents[v];
        if(pu < pv)
            parents[pv] = pu;
        else
            parents[pu] = pv;
    }
    static int find(int v){
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
}
