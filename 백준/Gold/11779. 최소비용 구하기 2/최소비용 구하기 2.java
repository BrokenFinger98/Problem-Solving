import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 388ms, 메모리 : 48,776KB
 */
public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;
        List<Integer> path;

        public Node(int to, int weight, List<Integer> path) {
            this.to = to;
            this.weight = weight;
            this.path = path;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    static int n, m, from, to, weight, start, end;
    static List<Integer> result = new ArrayList<>();
    static List<Node>[] list;
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight, null));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        List<Integer> newList = new ArrayList<>();
        newList.add(start);
        pq.offer(new Node(start, 0, newList));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.to] != now.weight) continue;
            if(now.to == end) {
                result = now.path;
                break;
            }
            for (Node next : list[now.to]) {
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    newList = new ArrayList<>(now.path);
                    newList.add(next.to);
                    pq.offer(new Node(next.to, dist[next.to], newList));
                }
            }
        }

        sb.append(dist[end]).append("\n");
        sb.append(result.size()).append("\n");
        for (Integer integer : result) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}

