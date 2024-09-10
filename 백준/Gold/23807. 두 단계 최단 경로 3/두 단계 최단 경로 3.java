import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 1,264ms, 메모리 : 161,152KB
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
    static long[] distFromX;
    static long[] distFromZ;
    static long[][] distFromY;
    static boolean[] isSelected;
    static int[] numbers;
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
        Y = new int[P+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            Y[i] = Integer.parseInt(st.nextToken());
        }

        distFromX = dijkstra(x);
        distFromZ = dijkstra(z);
        distFromY = new long[P+1][N+1];
        for (int i = 1; i <= P; i++) {
            distFromY[i] = dijkstra(Y[i]);
        }
        isSelected = new boolean[P+1];
        numbers = new int[3];
        permutation(0);

        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
        br.close();
    }
    static void permutation(int depth){
        if(depth == 3){
            long XtoY1 = distFromX[Y[numbers[0]]];
            long Y1toY2 = distFromY[numbers[0]][Y[numbers[1]]];
            long Y2toY3 = distFromY[numbers[1]][Y[numbers[2]]];
            long Y3toZ = distFromZ[Y[numbers[2]]];
            if(XtoY1 == Long.MAX_VALUE || Y1toY2 == Long.MAX_VALUE || Y2toY3 == Long.MAX_VALUE || Y3toZ == Long.MAX_VALUE) return;
            answer = Math.min(answer, XtoY1 + Y1toY2 + Y2toY3 + Y3toZ);
            return;
        }
        for (int i = 1; i <= P; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            numbers[depth] = i;
            permutation(depth + 1);
            isSelected[i] = false;
        }
    }

    static long[] dijkstra(int start){
        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.v] != now.w) continue;
            for (Node next : list[now.v]) {
                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}
