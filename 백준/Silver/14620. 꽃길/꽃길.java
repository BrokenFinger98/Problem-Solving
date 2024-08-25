import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N * N; i++) {
            int fy = i / N;
            int fx = i % N;
            if (checkRange(fy, fx)) {
                checked(fy, fx);
                for (int j = i + 1; j < N * N; j++) {
                    int sy = j / N;
                    int sx = j % N;
                    if(checkRange(sy, sx)){
                        if (check(sy, sx)) {
                            checked(sy, sx);
                            for (int k = j + 1; k < N * N; k++) {
                                int ty = k / N;
                                int tx = k % N;
                                if(checkRange(ty, tx)){
                                    if (check(ty, tx) && checkRange(ty, tx)) {
                                        checked(ty, tx);
                                        cntSum();
                                        unchecked(ty, tx);
                                    }
                                }
                            }
                            unchecked(sy, sx);
                        }
                    }
                }
                unchecked(fy, fx);
            }
        }

        System.out.println(result);
        br.close();
    }

    static void go(int y, int x, int depth) {
        if (depth == 3) {
            cntSum();
            return;
        }

        for (int i = y; i < N - 1; i++) {
            for (int j = x; j < N - 1; j++) {
                if (check(i, j)) {
                    checked(i, j);
                    go(i, j + 1, depth + 1);
                    unchecked(i, j);
                }
            }
        }
    }

    static void cntSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    sum += map[i][j];
            }
        }
        result = Math.min(result, sum);
    }

    static boolean checkRange(int i, int j) {
        if (i + 1 >= N || i - 1 < 0 || j - 1 < 0 || j + 1 >= N) return false;
        return true;
    }

    static boolean check(int i, int j) {
        if (visited[i][j] || visited[i + 1][j] || visited[i - 1][j] || visited[i][j + 1] || visited[i][j - 1])
            return false;
        return true;
    }

    static void checked(int i, int j) {
        visited[i][j] = visited[i + 1][j] = visited[i - 1][j] = visited[i][j + 1] = visited[i][j - 1] = true;
    }

    static void unchecked(int i, int j) {
        visited[i][j] = visited[i + 1][j] = visited[i - 1][j] = visited[i][j + 1] = visited[i][j - 1] = false;
    }
}
