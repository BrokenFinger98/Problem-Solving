import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  시간 : 448ms, 메모리 : 172,096KB
 */
public class Main {
    static class Pipe{
        int y;
        int x;

        public Pipe(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int result, N;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 1, 0};
    static int[] dx = {1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("0");
            }
        }

        visited[0][0] = true;
        visited[0][1] = true;
        dfs(0, 1, 2);
        System.out.println(result);
        br.close();
    }
    static void dfs(int y, int x, int shape){
        if(y == N-1 && x == N-1){
            result++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(shape == 1){
                if(i == 2) continue;
            }else if(shape == 2){
                if(i == 1) continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx  >= N || visited[ny][nx]) continue;
            if(i == 0 && (!map[ny-1][nx] || !map[ny][nx-1])) continue;
            if(map[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny, nx, i);
                visited[ny][nx] = false;
            }
        }
    }
}
