import java.util.*;

class Solution {
    int N, M;
    int[] redStart = new int[2];
    int[] blueStart = new int[2];
    int[] redEnd = new int[2];
    int[] blueEnd = new int[2];
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                switch (maze[i][j]) {
                    case 1 -> { redStart[0] = i; redStart[1] = j; }
                    case 2 -> { blueStart[0] = i; blueStart[1] = j; }
                    case 3 -> { redEnd[0] = i; redEnd[1] = j; }
                    case 4 -> { blueEnd[0] = i; blueEnd[1] = j; }
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<State> queue = new ArrayDeque<>();

        State start = new State(redStart[0], redStart[1], blueStart[0], blueStart[1], 0);
        start.redVisited.add(posKey(redStart[0], redStart[1]));
        start.blueVisited.add(posKey(blueStart[0], blueStart[1]));

        queue.offer(start);
        visited.add(stateKey(redStart[0], redStart[1], blueStart[0], blueStart[1]));

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.ry == redEnd[0] && cur.rx == redEnd[1] && cur.by == blueEnd[0] && cur.bx == blueEnd[1]) {
                return cur.turn;
            }

            boolean redArrived = cur.ry == redEnd[0] && cur.rx == redEnd[1];
            boolean blueArrived = cur.by == blueEnd[0] && cur.bx == blueEnd[1];

            List<int[]> redMoves = redArrived ? List.of(new int[]{cur.ry, cur.rx}) : getMoves(cur.ry, cur.rx, maze, cur.redVisited);
            List<int[]> blueMoves = blueArrived ? List.of(new int[]{cur.by, cur.bx}) : getMoves(cur.by, cur.bx, maze, cur.blueVisited);

            for (int[] red : redMoves) {
                for (int[] blue : blueMoves) {
                    int nry = red[0], nrx = red[1];
                    int nby = blue[0], nbx = blue[1];

                    if (nry == nby && nrx == nbx) continue;
                    if (nry == cur.by && nrx == cur.bx && nby == cur.ry && nbx == cur.rx) continue;

                    String stateKey = stateKey(nry, nrx, nby, nbx);
                    if (visited.contains(stateKey)) continue;

                    visited.add(stateKey);
                    State next = new State(nry, nrx, nby, nbx, cur.turn + 1);
                    next.redVisited.addAll(cur.redVisited);
                    next.blueVisited.addAll(cur.blueVisited);
                    next.redVisited.add(posKey(nry, nrx));
                    next.blueVisited.add(posKey(nby, nbx));
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    List<int[]> getMoves(int y, int x, int[][] maze, Set<String> visitedSet) {
        List<int[]> result = new ArrayList<>();
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M && maze[ny][nx] != 5) {
                if (!visitedSet.contains(posKey(ny, nx))) {
                    result.add(new int[]{ny, nx});
                }
            }
        }
        return result;
    }

    static class State {
        int ry, rx, by, bx, turn;
        Set<String> redVisited = new HashSet<>();
        Set<String> blueVisited = new HashSet<>();

        State(int ry, int rx, int by, int bx, int turn) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.turn = turn;
        }
    }

    String posKey(int y, int x) {
        return y + "," + x;
    }

    String stateKey(int ry, int rx, int by, int bx) {
        return ry + "," + rx + "," + by + "," + bx;
    }
}