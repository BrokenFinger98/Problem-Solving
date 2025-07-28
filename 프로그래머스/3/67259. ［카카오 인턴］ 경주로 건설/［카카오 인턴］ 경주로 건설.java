import java.util.*;

class Solution {
    static int[] dy = {1, 0, -1, 0}; 
    static int[] dx = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        for (int[][] row : cost)
            for (int[] cell : row)
                Arrays.fill(cell, Integer.MAX_VALUE);

        Queue<Node> q = new ArrayDeque<>();
        for (int d = 0; d < 2; d++) { 
            cost[0][0][d] = 0;
            q.offer(new Node(0, 0, d, 0));
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1)
                    continue;

                int newCost = cur.cost + ((cur.dir == dir) ? 100 : 600);

                if (cost[ny][nx][dir] > newCost) {
                    cost[ny][nx][dir] = newCost;
                    q.offer(new Node(ny, nx, dir, newCost));
                }
            }
        }

        return Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
    }

    static class Node {
        int y, x, dir, cost;

        Node(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
}