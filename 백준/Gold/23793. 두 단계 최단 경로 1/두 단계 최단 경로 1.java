import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static int N, M, u, v, w, x, y, z, XtoY = -1, YtoZ = -1, noneY;
    static int[] dist;
    static List<Node>[] list;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.v == y) break;
            if(dist[now.v] != now.w) continue;
            for (Node next : list[now.v]) {
                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        if(dist[y] != Integer.MAX_VALUE)
            XtoY = dist[y];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[y] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(y, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.v == z) break;
            if(dist[now.v] != now.w) continue;
            for (Node next : list[now.v]) {
                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        if(dist[z] != Integer.MAX_VALUE)
            YtoZ = dist[z];

        noneY = XtoY == -1 || YtoZ == -1 ? -1 : XtoY + YtoZ;
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.v == z) break;
            if(dist[now.v] != now.w) continue;
            for (Node next : list[now.v]) {
                if(next.v == y) continue;
                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        System.out.println(noneY+ " " + (dist[z] == Integer.MAX_VALUE ? -1 : dist[z]));
        br.close();
    }
}
