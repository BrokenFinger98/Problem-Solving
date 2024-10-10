import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int r, c;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] dis;
	private static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		dis = new int[r][c];
		
		int x = 0;
		int y = 0;
		
		int sx = 0;
		int sy = 0;
		List<int[]> water = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					x = i;
					y = j;
				} else if (map[i][j] == '*') {
					water.add(new int[] {i, j});
				} else if (map[i][j] == 'D') { 
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs(x, y, water, sx, sy);
		if (dis[sx][sy] == 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(dis[sx][sy]);
		}
	}
	
	public static void bfs(int x, int y, List<int[]> water, int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];
		for (int[] p : water) {
			q.add(new int[] {0, p[0], p[1]});
			visited[p[0]][p[1]] = true;
		}
		q.add(new int[] {1, x, y});//1은 고돔
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(dis[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int[] cur = q.poll();
			
			int type = cur[0];
			int cx = cur[1];
			int cy = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
				if (visited[nx][ny])continue;
				if (map[nx][ny] == 'X') continue;
				if (type == 1 && map[nx][ny] == '*') continue;
				if (type == 0 && map[nx][ny] == 'D') continue;
				if (type == 0) {
					visited[nx][ny] = true;
					map[nx][ny] = '*';
					q.add(new int[] {0, nx, ny});
				} else {
					visited[nx][ny] = true;
					dis[nx][ny] = dis[cx][cy] + 1;
					q.add(new int[] {1, nx, ny});
				}
			}
		}
	}

}
