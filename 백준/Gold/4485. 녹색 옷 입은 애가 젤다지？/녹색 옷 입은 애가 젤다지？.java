import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  시간 : 440ms, 메모리 : 37,880KB
 */
public class Main {
    static class Node implements Comparable<Node>{
        int y, x, weight;

        public Node(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, cnt = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        while (true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) System.exit(0);
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            sb = new StringBuilder();
            sb.append("Problem").append(" ").append(cnt++).append(":").append(" ").append(dist[N-1][N-1]);
            System.out.println(sb.toString());
        }
    }
    static void dijkstra(){
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[0][0];
        pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, dist[0][0]));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            int y = now.y;
            int x = now.x;
            int weight = now.weight;
            if(y == N-1 && x == N-1) break;
            if(dist[y][x] != weight) continue;
            visited[y][x] = true;
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
                if(dist[ny][nx] > map[ny][nx] + weight){
                    dist[ny][nx] = map[ny][nx] + weight;
                    pq.offer(new Node(ny, nx, dist[ny][nx]));
                }
            }
        }
    }
}
