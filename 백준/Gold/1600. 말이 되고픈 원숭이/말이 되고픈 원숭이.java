import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey{
    int y;
    int x;
    int useJumpCnt;

    public Monkey(int y, int x, int useJumpCnt) {
        this.y = y;
        this.x = x;
        this.useJumpCnt = useJumpCnt;
    }
}
public class Main {
    static int H, W, K, min = Integer.MAX_VALUE;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] jumpY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] jumpX = {2, 1, -1, -2, -2, -1, 1, 2};
    static boolean[][] map = new boolean[204][204];
    static int[][][] visited = new int[204][204][34];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for (int i = 0; i < H; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = st.nextToken().equals("0");
            }
        }
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        br.close();
    }

    static void bfs(){
        Queue<Monkey> queue = new ArrayDeque<>();
        queue.offer(new Monkey(0, 0, 0));
        while (!queue.isEmpty()) {
            Monkey now = queue.poll();
            int y = now.y;
            int x = now.x;
            int useJumpCnt = now.useJumpCnt;
            if(y == H-1 && x == W-1){
                min = Math.min(min, visited[y][x][useJumpCnt]);
                continue;
            }
            // 점프 하는 경우
            if(useJumpCnt < K){
                for (int i = 0; i < 8; i++) {
                    int ny = y + jumpY[i];
                    int nx = x + jumpX[i];
                    if(!checkRange(ny, nx)) continue;
                    if(map[ny][nx] && visited[ny][nx][useJumpCnt + 1] == 0 ){
                        visited[ny][nx][useJumpCnt + 1] = visited[y][x][useJumpCnt] + 1;
                        queue.offer(new Monkey(ny, nx, useJumpCnt+1));
                    }
                }
            }
            // 그냥 가는 경우
            for(int i = 0; i < 4; ++i){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(!checkRange(ny, nx)) continue;
                if(map[ny][nx] && visited[ny][nx][useJumpCnt] == 0 ){
                    visited[ny][nx][useJumpCnt] = visited[y][x][useJumpCnt] + 1;
                    queue.offer(new Monkey(ny, nx, useJumpCnt));
                }
            }
        }
    }
    static boolean checkRange(int ny, int nx){
        if (ny < 0 || ny >= H || nx < 0 || nx >= W) return false;
        return true;
    }
}
