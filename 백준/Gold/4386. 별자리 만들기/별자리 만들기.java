import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 1,056ms, 메모리 : 321,700KB
 */
public class Main {
    static class Star{
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Node implements Comparable<Node>{
        int to;
        double weight;

        public Node(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.weight, o.weight);
        }
    }
    static int n, cnt;
    static Star[] stars;
    static double answer;
    static boolean[] visited;
    static double fromX, fromY, toX, toY, weight;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static List<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stars = new Star[n];
        visited = new boolean[n];
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            fromX = stars[i].x;
            fromY = stars[i].y;
            for (int j = i + 1; j < n; j++) {
                toX = stars[j].x;
                toY = stars[j].y;
                weight = Math.sqrt(Math.pow(fromX - toX, 2) + Math.pow(fromY - toY, 2));
                adj[i].add(new Node(j, weight));
                adj[j].add(new Node(i, weight));
            }
        }
        
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.to]) continue;
            visited[node.to] = true;
            answer += node.weight;
            ++cnt;
            if(cnt == n) break;
            for (Node next : adj[node.to]) {
                if(visited[next.to]) continue;
                pq.offer(next);
            }
        }

        System.out.printf("%.2f\n", answer);
        br.close();
    }
}
