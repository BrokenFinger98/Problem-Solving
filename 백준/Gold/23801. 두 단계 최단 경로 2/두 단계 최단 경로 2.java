import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 872ms, 메모리 : 105,004KB
 */
public class Main {
    static class Node implements Comparable<Node>{
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w) ;
        }
    }
    static int N, M, u, v, w, x, z, P;
    static long answer = Long.MAX_VALUE;
    static int[] Y;
    static long[][] dist;
    static List<Node>[] list;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(br.readLine());
        Y = new int[P];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            Y[i] = Integer.parseInt(st.nextToken());
        }

        dist = new  long[2][N+1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        dijkstra(0, x);
        dijkstra(1, z);

        for (int i = 0; i < P; i++) {
            int mid = Y[i];
            if(dist[0][mid] != Long.MAX_VALUE && dist[1][mid] != Long.MAX_VALUE) {
                answer = Math.min(answer, dist[0][mid] + dist[1][mid]);
            }
        }

        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void dijkstra(int index, int start){
        dist[index][start] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[index][now.v] != now.w) continue;
            for (Node next : list[now.v]) {
                if (dist[index][next.v] > dist[index][now.v] + next.w) {
                    dist[index][next.v] = dist[index][now.v] + next.w;
                    pq.offer(new Node(next.v, dist[index][next.v]));
                }
            }
        }
    }
}
