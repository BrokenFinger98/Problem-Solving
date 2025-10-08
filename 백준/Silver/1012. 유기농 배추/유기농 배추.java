import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] map = new boolean[N][M];
			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}

			int count = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if(map[i][j] && !visited[i][j]) {
						bfs(map, visited, i, j);
						++count;
					}
				}
			}

			System.out.println(count);
		}
		
		br.close();
	}

	private static void bfs(boolean[][] map, boolean[][] visited, int y, int x) {
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};
		int N = map.length;
		int M = map[0].length;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{y, x});
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; ++i) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if(map[ny][nx] && !visited[ny][nx]) {
					visited[ny][nx] = true;
					queue.add(new int[]{ny, nx});
				}
			}
		}
	}
}