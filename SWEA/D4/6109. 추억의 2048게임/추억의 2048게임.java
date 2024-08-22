import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int T, N;
    static String operator;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; ++t) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            operator = st.nextToken();
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            move(operator);
            printMap(t);
        }
        br.close();
    }

    static void move(String operator) {
        if (operator.equals("up")) {
            for (int j = 0; j < N; j++) {
                for (int i = 1; i < N; ++i) {
                    if (map[i][j] == 0) continue;
                    int k = 1;
                    while (map[i - k][j] == 0 && i - k > 0) {
                        ++k;
                    }
                    if (map[i - k][j] == 0 && i - k == 0) {
                        map[i - k][j] = map[i][j];
                        map[i][j] = 0;
                        continue;
                    }
                    if (!visited[i - k][j] && map[i - k][j] == map[i][j]) {
                        visited[i - k][j] = true;
                        map[i - k][j] *= 2;
                        map[i][j] = 0;
                    } else {
                        if (k == 1) continue;
                        map[i - k + 1][j] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        } else if (operator.equals("down")) {
            for (int j = 0; j < N; j++) {
                for (int i = N - 2; i >= 0; --i) {
                    if (map[i][j] == 0) continue;
                    int k = 1;
                    while (map[i + k][j] == 0 && i + k < N - 1) {
                        ++k;
                    }
                    if (map[i + k][j] == 0 && i + k == N-1) {
                        map[i + k][j] = map[i][j];
                        map[i][j] = 0;
                        continue;
                    }
                    if (!visited[i + k][j] && map[i + k][j] == map[i][j]) {
                        visited[i + k][j] = true;
                        map[i + k][j] *= 2;
                        map[i][j] = 0;
                    } else {
                        if (k == 1) continue;
                        map[i + k - 1][j] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        } else if (operator.equals("right")) {
            for (int j = N - 2; j >= 0; j--) {
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 0) continue;
                    int k = 1;
                    while (map[i][j + k] == 0 && j + k < N - 1) {
                        ++k;
                    }
                    if (map[i][j + k] == 0 && j + k == N-1) {
                        map[i][j + k] = map[i][j];
                        map[i][j] = 0;
                        continue;
                    }
                    if (!visited[i][j + k] && map[i][j + k] == map[i][j]) {
                        visited[i][j + k] = true;
                        map[i][j + k] *= 2;
                        map[i][j] = 0;
                    } else {
                        if (k == 1) continue;
                        map[i][j + k - 1] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        } else {
            for (int j = 1; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 0) continue;
                    int k = 1;
                    while (map[i][j - k] == 0 && j - k > 0) {
                        ++k;
                    }
                    if (map[i][j - k] == 0 && j - k == 0) {
                        map[i][j - k] = map[i][j];
                        map[i][j] = 0;
                        continue;
                    }
                    if (!visited[i][j - k] && map[i][j - k] == map[i][j]) {
                        visited[i][j - k] = true;
                        map[i][j - k] *= 2;
                        map[i][j] = 0;
                    } else {
                        if (k == 1) continue;
                        map[i][j - k + 1] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void printMap(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(t).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}