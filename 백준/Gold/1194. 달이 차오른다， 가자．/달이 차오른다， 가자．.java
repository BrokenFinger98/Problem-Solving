import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Minsik {
    int y;
    int x;
    int flag;

    public Minsik(int y, int x, int flag) {
        this.y = y;
        this.x = x;
        this.flag = flag;
    }
}

public class Main {
    static int N, M, sy, sx;
    static char[][] map;
    static int[][][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M][64];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '0'){
                    sy = i;
                    sx = j;
                }
            }
        }

        bfs();

        System.out.println(-1);
        br.close();
    }

    static void bfs() {
        Queue<Minsik> queue = new ArrayDeque<>();
        queue.offer(new Minsik(sy, sx, 0));
        while (!queue.isEmpty()) {
            Minsik now = queue.poll();
            int y = now.y;
            int x = now.x;
            int flag = now.flag;
            if (map[y][x] == '1') {
                System.out.println(visited[y][x][flag]);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nextFlag = flag;
                if (!checkRange(ny, nx, flag)) continue;
                if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F'){
                    if((flag | 1 << (map[ny][nx] - 'A')) != flag) continue;
                }else if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f'){
                    nextFlag = flag | 1 << (map[ny][nx] - 'a');
                }
                visited[ny][nx][nextFlag] = visited[y][x][flag] + 1;
                queue.offer(new Minsik(ny, nx, nextFlag));
            }
        }
    }

    static boolean checkRange(int ny, int nx, int flag) {
        if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == '#' || visited[ny][nx][flag] != 0) return false;
        return true;
    }
}
