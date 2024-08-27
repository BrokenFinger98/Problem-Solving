import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int T, N, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new char[N][N];
            visited = new boolean[N][N];
            cnt = 0;
            
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            // Step 1: "0"인 영역을 먼저 찾아서 BFS를 수행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && countMines(i, j) == 0) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            // Step 2: 나머지 탐색되지 않은 "." 칸들을 클릭하여 모두 열린 상태로 만들기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        cnt++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        
        System.out.print(sb.toString());
    }

    static void bfs(int starty, int startx) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(starty, startx));
        visited[starty][startx] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int y = now.y;
            int x = now.x;

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;

                if (map[ny][nx] == '.') {
                    visited[ny][nx] = true;
                    if (countMines(ny, nx) == 0) {
                        queue.offer(new Node(ny, nx));
                    }
                }
            }
        }
    }

    static int countMines(int y, int x) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == '*') {
                count++;
            }
        }
        return count;
    }
}
