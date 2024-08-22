import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) == '.';
            }
        }

        for(int i = 0; i < R; ++i){
            if(dfs(i, 0)) ++result;
        }

        System.out.println(result);
        br.close();
    }
    static boolean dfs(int y, int x){
        if(x == C-1){
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || visited[ny][nx] || !map[ny][nx]) continue;
            visited[ny][nx] = true;
            if(dfs(ny, nx)) return true;
        }
        return false;
    }
}
