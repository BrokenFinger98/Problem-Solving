import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(bfs(new int[]{0, 0}, new int[]{N - 1, M - 1}, map));
		br.close();
	}

	private static int bfs(int[] start, int[] end, int[][] map) {
		int N = map.length;
		int M = map[0].length;
		int[][] visited = new int[N][M];
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start[0]][start[1]] = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == end[0] && cur[1] == end[1]) {
				return visited[cur[0]][cur[1]];
			}
			for (int i = 0; i < 4; ++i) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
					visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
					queue.add(new int[]{ny, nx});
				}
			}
		}
		return visited[end[0]][end[1]];
	}
}