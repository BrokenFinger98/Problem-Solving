import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, start, result = 0, roomNum;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            sb = new StringBuilder();
            result = 0;
            roomNum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    start = map[i][j];
                    dfs(i, j, 1);
                }
            }
            sb.append("#").append(t).append(" ").append(roomNum).append(" ").append(result);
            System.out.println(sb.toString());
        }
    }
    static void dfs(int y, int x, int cnt){
        if(cnt > result){
            result = cnt;
            roomNum = start;
        }else if(cnt == result){
            if(roomNum > start){
                result = cnt;
                roomNum = start;
            }
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(map[ny][nx] == map[y][x] + 1){
                dfs(ny, nx, cnt + 1);
            }
        }
    }
}
