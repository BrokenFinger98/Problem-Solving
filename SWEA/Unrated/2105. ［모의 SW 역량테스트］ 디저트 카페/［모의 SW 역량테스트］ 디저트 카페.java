import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  수정된 코드
 */
public class Solution {
    static int T, N, result;
    static Set<Integer> set;
    static int[][] map;
    static int[] dy = {1, 1, -1, -1}; // 이동 방향 (우하, 좌하, 좌상, 우상)
    static int[] dx = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            result = -1;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    set = new HashSet<>();
                    set.add(map[i][j]);
                    dfs(i, j, i, j, 0, 1);
                }
            }

            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb.toString());
        }
    }

    static void dfs(int startY, int startX, int y, int x, int dir, int count) {
        for (int d = dir; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny == startY && nx == startX && count >= 4) { // 사각형을 완성하고 출발점으로 돌아온 경우
                result = Math.max(result, count);
                return;
            }

            if (checkRange(ny, nx) && !set.contains(map[ny][nx])) {
                set.add(map[ny][nx]);
                dfs(startY, startX, ny, nx, d, count + 1);
                set.remove(map[ny][nx]); // 백트래킹
            }
        }
    }

    static boolean checkRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}
