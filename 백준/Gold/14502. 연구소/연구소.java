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
    static int result;
    static int[][] mp;
    static int[][] mp1;
    static List<Pair> virus = new ArrayList<>();
    static List<Pair> beWall = new ArrayList<>();
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mp = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                mp[i][j] = Integer.parseInt(st.nextToken());
                if (mp[i][j] == 2) {
                    virus.add(new Pair(i, j));
                } else if (mp[i][j] == 0) {
                    beWall.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < beWall.size(); ++i) {
            for (int j = i + 1; j < beWall.size(); ++j) {
                for (int k = j + 1; k < beWall.size(); ++k) {
                    back();
                    mp1[beWall.get(i).y][beWall.get(i).x] = 1;
                    mp1[beWall.get(j).y][beWall.get(j).x] = 1;
                    mp1[beWall.get(k).y][beWall.get(k).x] = 1;
                    bfs();
                }
            }
        }
        System.out.println(result);
    }

    static void back() {
        mp1 = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                mp1[i][j] = mp[i][j];
            }
        }
    }

    static void bfs() {
        Deque<Pair> stack = new ArrayDeque<>();
        for (Pair pair : virus) {
            stack.push(pair);
        }
        while (!stack.isEmpty()) {
            Pair now = stack.pop();
            for (int i = 0; i < 4; ++i) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (mp1[ny][nx] == 0) {
                    mp1[ny][nx] = 2;
                    stack.push(new Pair(ny, nx));
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (mp1[i][j] == 0) ++sum;
            }
        }
        result = Math.max(sum, result);
    }
}