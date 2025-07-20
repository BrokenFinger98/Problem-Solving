import java.util.*;
import java.io.*;

public class Main {
	static int[][] visited = new int[501][501];
	static int[][] map = new int[501][501];
	static ArrayDeque<int[]> queue = new ArrayDeque<>();
	static int N, M;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] pos1 = new int[2];
		int[] pos2 = new int[2];

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			pos1[0] = Integer.parseInt(st.nextToken());
			pos1[1] = Integer.parseInt(st.nextToken());
			pos2[0] = Integer.parseInt(st.nextToken());
			pos2[1] = Integer.parseInt(st.nextToken());
			makeArea(pos1, pos2, 1);
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			pos1[0] = Integer.parseInt(st.nextToken());
			pos1[1] = Integer.parseInt(st.nextToken());
			pos2[0] = Integer.parseInt(st.nextToken());
			pos2[1] = Integer.parseInt(st.nextToken());
			makeArea(pos1, pos2, -1);
		}

		System.out.println(bfs());
	}

	private static void makeArea(int[] pos1, int[] pos2, int num) {
		int fromX = Math.min(pos1[0], pos2[0]);
		int toX = Math.max(pos1[0], pos2[0]);
		int fromY = Math.min(pos1[1], pos2[1]);
		int toY = Math.max(pos1[1], pos2[1]);
		for (int y = fromY; y <= toY; ++y) {
			for (int x = fromX; x <= toX; ++x) {
				map[y][x] = num;
			}
		}
	}

	private static int bfs() {
		map[0][0] = 0;
		for (int i = 0; i <= 500; ++i) {
			Arrays.fill(visited[i], 2501);
		}

		queue.offer(new int[]{0, 0});
		visited[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int y = now[0];
			int x = now[1];
			if (y == 500 && x == 500) continue;
			for (int i = 0; i < 4; ++i) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny > 500 || nx < 0 || nx > 500 || map[ny][nx] == -1) continue;
				if (map[ny][nx] == 0 && visited[ny][nx] > visited[y][x]) {
					visited[ny][nx] = visited[y][x];
					queue.offerFirst(new int[]{ny, nx});
				} else if (map[ny][nx] == 1 && visited[ny][nx] > visited[y][x] + 1) {
					visited[ny][nx] = visited[y][x] + 1;
					queue.offerLast(new int[]{ny, nx});
				}
			}
		}

		return visited[500][500] != 2501 ? visited[500][500] : -1;
	}
}