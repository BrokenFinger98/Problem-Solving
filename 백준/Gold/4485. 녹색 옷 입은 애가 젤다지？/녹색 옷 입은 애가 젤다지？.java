import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc=1;
		while((N=Integer.parseInt(br.readLine()))>0) {
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[N][N];
			int[][] costs = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(costs[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b)->Integer.compare(a[2], b[2]));
			q.add(new int[] {0, 0, map[0][0]});
			costs[0][0] = map[0][0];
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(visited[cur[0]][cur[1]]) continue;
				visited[cur[0]][cur[1]] = true;
				int cost = costs[cur[0]][cur[1]];
				if(cur[0] == N-1 && cur[1] == N-1) break;
				for (int[] dir: dirs) {
					int ny = cur[0] + dir[0];
					int nx = cur[1] + dir[1];
					if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
					if(costs[ny][nx] <= cost+map[ny][nx]) continue;
					costs[ny][nx] = cost+map[ny][nx];
					q.add(new int[] {ny, nx, costs[ny][nx]});
				}
			}
			sb.append("Problem ").append(tc++).append(": ").append(costs[N-1][N-1]).append('\n');
		}
		System.out.println(sb.toString());
	}
}
