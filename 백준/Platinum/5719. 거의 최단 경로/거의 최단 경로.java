import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 360ms, 메모리 : 60,852KB
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
    static int N, M, U, V, P, S, D;
    static boolean[][] check;
    static List<Node>[] list;
    static List<Integer>[] parents;
    static Queue<Integer> q;
    static int[] dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            list = new List[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            parents = new List[N];
            for (int i = 0; i < N; i++) {
                parents[i] = new ArrayList<>();
            }
            dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                U = Integer.parseInt(st.nextToken());
                V = Integer.parseInt(st.nextToken());
                P = Integer.parseInt(st.nextToken());
                list[U].add(new Node(V, P));
            }

            dist[S] = 0;
            pq = new PriorityQueue<>();
            pq.offer(new Node(S, 0));
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if(dist[now.to] != now.weight) continue;
                if(now.to == D && dist[D] == now.weight) {
                    continue;
                }
                for (Node next : list[now.to]) {
                    if (dist[next.to] > dist[now.to] + next.weight) {
                        dist[next.to] = dist[now.to] + next.weight;
                        parents[next.to] = new ArrayList<>();
                        parents[next.to].add(now.to);
                        pq.offer(new Node(next.to, dist[next.to]));
                    }else if(dist[next.to] == dist[now.to] + next.weight){
                        parents[next.to].add(now.to);
                    }
                }
            }

            check = new boolean[N][N];
            q = new ArrayDeque<>();
            q.add(D);

            while (!q.isEmpty()) {
                int now = q.poll();
                for (int parent : parents[now]) {
                    if (!check[parent][now]) {  // 이미 체크된 간선이 아니면
                        check[parent][now] = true;
                        q.add(parent);  // 부모 노드로 거슬러 올라가면서 추적
                    }
                }
            }

            dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[S] = 0;
            pq = new PriorityQueue<>();
            pq.offer(new Node(S, 0));
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if(now.to == D) break;
                if(dist[now.to] != now.weight) continue;
                for (Node next : list[now.to]) {
                    if(check[now.to][next.to]) continue;
                    if (dist[next.to] > dist[now.to] + next.weight) {
                        dist[next.to] = dist[now.to] + next.weight;
                        pq.offer(new Node(next.to, dist[next.to]));
                    }
                }
            }

            sb.append(dist[D] == Integer.MAX_VALUE ? -1 : dist[D]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}

