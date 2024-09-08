import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 512ms, 메모리 : 67,680KB
 */
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
    static int N, M, X, from, to, weight, answer;
    static List<Node>[] list;
    static int[][] dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }

        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
            pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if(now.to == X && i != X) break;
                if(dist[i][now.to] != now.weight) continue;
                for (Node next : list[now.to]) {
                    if (dist[i][next.to] > dist[i][now.to] + next.weight) {
                        dist[i][next.to] = dist[i][now.to] + next.weight;
                        pq.offer(new Node(next.to, dist[i][next.to]));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            answer = Math.max(answer, dist[i][X] + dist[X][i]);
        }
        System.out.println(answer);
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
