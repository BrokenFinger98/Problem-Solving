import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N, M, answer;
    static boolean[][] map;
    static int[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] parent;
    static List<List<Node>> islands = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        // 섬 만들기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] && visited[i][j] == 0){
                    bfs(i, j);
                }
            }
        }

        // 간선 구하기
        for (int i = 0; i < islands.size(); i++) {
            for (int j = 0; j < islands.get(i).size(); j++) {
                Node now = islands.get(i).get(j);
                int y = now.y;
                int x = now.x;
                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if(visited[ny][nx] == 0){
                        int dist = 1;
                        boolean flag = false;
                        while (true){
                            ny += dy[k];
                            nx += dx[k];
                            if(ny < 0 || ny >= N || nx < 0 || nx >= M) break;
                            if(visited[ny][nx] != 0){
                                flag = true;
                                break;
                            }
                            ++dist;
                        }
                        if(dist >= 2 && flag)
                            pq.offer(new Edge(visited[y][x]-1, visited[ny][nx]-1, dist));
                    }
                }
            }
        }

        // kruskal
        parent = new int[islands.size()];
        for (int i = 0; i < islands.size(); i++) {
            parent[i] = i;
        }
        int connectedEdge = 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;
            if(find(from) != find(to)){
                union(from, to);
                answer += weight;
                connectedEdge++;
            }
        }
        if(connectedEdge+1 != islands.size()) answer = 0;
        System.out.println(answer == 0 ? -1 : answer);
    }
    static void bfs(int startY, int startX){
        islands.add(new ArrayList<>());
        visited[startY][startX] = islands.size();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startY, startX));
        while (!queue.isEmpty()){
            Node now = queue.poll();
            islands.get(islands.size()-1).add(now);
            int y = now.y;
            int x = now.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(visited[ny][nx] == 0 && map[ny][nx]){
                    visited[ny][nx] = islands.size();
                    queue.offer(new Node(ny, nx));
                }
            }
        }
    }
    static void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu < pv) parent[pv] = pu;
        else parent[pu] = pv;
    }

    static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
}

