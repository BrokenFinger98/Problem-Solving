import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    static int T, N;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] result;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; ++t){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            num = 1;
            visited = new boolean[N][N];
            result = new int[N][N];
            visited[0][0] = true;
            result[0][0] = num++;

            go(0, 0);

            System.out.println("#" + t);
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
        br.close();
    }

    static void go(int y, int x) {
        for (int i = 0; i < 4; ++i) {
            while (true) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) {
                    break;
                }
                y = ny;
                x = nx;
                result[y][x] = num++;
                visited[y][x] = true;
            }
        }

        // 재귀 호출을 수정합니다.
        for (int i = 0; i < 4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                result[ny][nx] = num++;
                visited[ny][nx] = true;
                go(ny, nx);
            }
        }
    }
}
