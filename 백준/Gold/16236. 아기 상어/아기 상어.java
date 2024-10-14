import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair>{
        int y, x, dist;

        public Pair(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.dist == o.dist) {
                if(this.y == o.y) return this.x - o.x;
                return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }

    static int N;
    static int[][] map;
    static int[][] visited;
    static int size = 2;
    static int exp = 0;
    static int answer = 0;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new int[N][N];
        Pair shark = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    shark = new Pair(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Pair target = bfs(shark);  
            if (target == null) break;  
            answer += target.dist; 
            shark = new Pair(target.y, target.x, 0); 
            map[target.y][target.x] = 0;  
            exp++;
            if (exp == size) {
                size++; 
                exp = 0;
            }
        }

        System.out.println(answer); 
    }

    static Pair bfs(Pair shark) {
        Queue<Pair> queue = new ArrayDeque<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        queue.offer(shark);
        visited = new int[N][N];  
        visited[shark.y][shark.x] = 1;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            int y = now.y;
            int x = now.x;
            int dist = now.dist;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(visited[ny][nx] != 0 || map[ny][nx] > size) continue;

                visited[ny][nx] = visited[y][x] + 1;
                queue.offer(new Pair(ny, nx, dist + 1));

                if (map[ny][nx] != 0 && map[ny][nx] < size) {
                    pq.offer(new Pair(ny, nx, dist + 1));  
                }
            }
        }
        return pq.isEmpty() ? null : pq.poll();  
    }
}
