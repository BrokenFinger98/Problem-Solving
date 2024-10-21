import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Island implements Comparable<Island> {
		int from;
		int to;
		int dis;

		public Island(int from, int to, int dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}
		
		@Override
		public String toString() {
			return "Island [from=" + from + ", to=" + to + ", dis=" + dis + "]";
		}

		public int compareTo(Island o) {
			return this.dis - o.dis;
		}
	}
	
	private static int n, m, answer, count, mapIndex = 2;
	private static int[] parents;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr;
	private static boolean[][] visited;
	private static PriorityQueue<Island> pq;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		init(br);
		makeMapIndex();
		calculateIslandDistance();
		findMinBridgeDistance();
		
		if (answer == 0 || (mapIndex-3) != count) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		parents = new int[8];
		for (int i = 0; i < 8; i++) {
			parents[i] = i;
		}
	}

	private static void makeMapIndex() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (flag(i, j)) mapIndex++;
			}
		}
	}
	
	public static boolean flag(int x, int y) { 
		if (x < 0 || x >= n || y < 0 || y >= m) return false;
		
		if (arr[x][y] == 1) {
			arr[x][y] = mapIndex;
			
			flag(x+1, y);
			flag(x-1, y);
			flag(x, y+1);
			flag(x, y-1);
			return true;
		}
		return false;
	}
	
	private static void calculateIslandDistance() {
		visited = new boolean[n][m];
		pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0) {//섬에서 섬 사이의 거리 구하기
					findSameIsland(i, j, arr[i][j]);
				}
			}
		}
	}
	
	private static void findSameIsland(int x, int y, int mapNum) {
		if (visited[x][y]) return;
		//해당 좌표에서 bfs
		//각 좌표에서 상하좌우로 퍼지면서 섬들 사이의 거리 구하기
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] p = q.poll();
			
			saveDistance(p, mapNum);
			int cx = p[0];
			int cy = p[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (visited[nx][ny] || arr[nx][ny] != mapNum) continue;
				//같은 숫자일 때
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}

	private static void saveDistance(int[] p, int mapNum) {
		for (int i = 0; i < 4; i++) {
			int cx = p[0];
			int cy = p[1];
			
			int count = 0;
			while (true) {
				count++;
				int nx = cx + dx[i]*count;
				int ny = cy + dy[i]*count;
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == mapNum) break;
				if (arr[nx][ny] != mapNum && arr[nx][ny] != 0) {
					//다른 섬과 만나고 길이가 2이상 이라면
					//count-1값을 저장해주면 됨
					//다른 섬과 만나면 바로 빠져나가기
					pq.offer(new Island(mapNum, arr[nx][ny], count-1));
					break;
				}
			}
		}
	}

	private static void findMinBridgeDistance() {
		answer = 0;
		count = 0;
		while (!pq.isEmpty()) {
			Island island = pq.poll();
			int dis = island.dis;
			if (dis == 1) continue;
			
			int from = island.from;
			int to = island.to;
			
			if (findParent(from) != findParent(to)) {
				unionParent(from, to);
				answer += dis;
				count++;
			}
		}
	}
	
	private static int findParent(int a) {
		if (parents[a] == a) return a;
		else return parents[a] = findParent(parents[a]);
	}
	
	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) parents[b] = a;
		else parents[a] = b;
	}
	
	private static boolean isSameParents() {
		for (int i = 2; i < mapIndex-1; i++) {
			if (parents[i] != parents[i+1]) return false;
		}
		return true;
	}
}
