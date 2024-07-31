import java.util.*;
import java.io.*;
import java.lang.*;

class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int N, M;
    static List<Pair> treasure = new ArrayList<>();
    static char[][] mp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mp = new char[N][M];

        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < M; ++j) {
                mp[i][j] = s.charAt(j);
                if(mp[i][j] == 'L') treasure.add(new Pair(i, j));
            }
        }

        for (int i = 0; i < treasure.size(); ++i) {
            visited = new int[N][M];
            result = Math.max(result, bfs(treasure.get(i)));
        }
        System.out.println(result - 1);
    }

    static int bfs(Pair start) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = 1;
        int max = 0;
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int y = now.y;
            int x = now.x;
            for (int i = 0; i < 4; ++i) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (mp[ny][nx] == 'L' && visited[ny][nx] == 0) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                    max = Math.max(max, visited[ny][nx]);
                }
            }
        }
        return max;
    }
}