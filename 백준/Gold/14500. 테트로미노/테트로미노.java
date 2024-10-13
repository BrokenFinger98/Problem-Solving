import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int maxValue = Integer.MIN_VALUE;
    static int[][] grid;
    static boolean[][] visited;
    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                findMaxTetrominoSum(i, j, grid[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(maxValue);
    }

    static void findMaxTetrominoSum(int row, int col, int sum, int depth) {
        if (depth == 4) {
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
                continue;
            }

            if (!visited[newRow][newCol]) {
                if (depth == 2) {
                    visited[newRow][newCol] = true;
                    findMaxTetrominoSum(row, col, sum + grid[newRow][newCol], depth + 1);
                    visited[newRow][newCol] = false;
                }

                visited[newRow][newCol] = true;
                findMaxTetrominoSum(newRow, newCol, sum + grid[newRow][newCol], depth + 1);
                visited[newRow][newCol] = false;
            }
        }
    }
}
