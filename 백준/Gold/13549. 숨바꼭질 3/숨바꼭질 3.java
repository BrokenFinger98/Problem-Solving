import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    static int N, K, to, weight;
    static List<Node>[] list;
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new List[K + K/2 + 1];
        for (int i = 0; i <= K + K/2; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[K + K/2 + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        if(K <= N){
            System.out.println(N-K);
            System.exit(0);
        }
        for (int i = 0; i <= K + K/2; i++) {
            if(i > 0){
                to = i-1;
                weight = 1;
                list[i].add(new Node(to, weight));
            }
            if(i < K){
                to = i+1;
                weight = 1;
                list[i].add(new Node(to, weight));
            }
            if(K-i >= i*2-K){
                to = i*2;
                weight = 0;
                list[i].add(new Node(to, weight));
            }
        }

        dist[N] = 0;
        pq.offer(new Node(N, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] != now.weight) continue;
            for (Node next : list[now.to]) {
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        System.out.println(dist[K]);
    }
}
//public class Main {
//    static int T, N, answer = Integer.MAX_VALUE;
//    static int[][] map;
//    static int[][] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        N = 8;
//        map = new int[9][9];
//        dp = new int[9][9];
//
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
//            }
//        }
//        System.out.println(dp[N][N]);
//    }
//}
