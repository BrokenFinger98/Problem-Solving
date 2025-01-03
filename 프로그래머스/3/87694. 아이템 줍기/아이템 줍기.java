import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static boolean[][] map = new boolean[104][104];
    private static int[][] visited = new int[104][104];
    private static int[][] rectangles;
    private static Position now;
    private static Position item;

    private static class Position {
        int y, x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public static boolean isArrive(Position character, Position item) {
            return item.y == character.y && item.x == character.x;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        now = new Position(characterY * 2, characterX * 2);
        item = new Position(itemY * 2, itemX * 2);
        rectangles = rectangle;
        resetArrays();
        init();
        return bfs();
    }

    public void resetArrays() {
        for (int i = 0; i < 104; i++) {
            for (int j = 0; j < 104; j++) {
                map[i][j] = false;
                visited[i][j] = 0;
            }
        }
    }

    public void init() {
        for (int[] rectangle : rectangles) {
            for (int j = rectangle[0] * 2; j <= rectangle[2] * 2; j++) {
                map[rectangle[1] * 2][j] = true;
                map[rectangle[3] * 2][j] = true;
            }
            for (int j = rectangle[1] * 2; j <= rectangle[3] * 2; j++) {
                map[j][rectangle[0] * 2] = true;
                map[j][rectangle[2] * 2] = true;
            }
        }
    }

    public int bfs() {
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(now);
        visited[now.y][now.x] = 1;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (Position.isArrive(now, item)) {
                return visited[item.y][item.x] / 2;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (canGo(ny, nx)) {
                    queue.add(new Position(ny, nx));
                    visited[ny][nx] = visited[now.y][now.x] + 1;
                }
            }
        }
        return -1;
    }

    public boolean canGo(int y, int x) {
        if (y < 0 || y >= map.length || x < 0 || x >= map[0].length) return false;
        if (!map[y][x] || visited[y][x] != 0) return false;
        for (int[] rectangle : rectangles) {
            if (y > rectangle[1] * 2 && y < rectangle[3] * 2 && x > rectangle[0] * 2 && x < rectangle[2] * 2) return false;
        }
        return true;
    }
}
