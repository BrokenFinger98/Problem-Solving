import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static class Fish{
		int x;
		int y;
		int d;
		boolean isAlive;

		public Fish(int x, int y, int d, boolean isAlive) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.isAlive = isAlive;
		}

		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
	
	private static int max = Integer.MIN_VALUE;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static Fish shark;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] fishMap = new int[4][4];
		Fish[] fishes = new Fish[17];
		int answer = init(br, fishes, fishMap);
		dfs(fishes, fishMap, answer);
		System.out.println(max);
	}

	

	private static int init(BufferedReader br, Fish[] fishes, int[][] fishMap) throws IOException {
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int fishNum = Integer.parseInt(st.nextToken());
				int fishDir = Integer.parseInt(st.nextToken())-1;
				
				fishMap[i][j] = fishNum;
				fishes[fishNum] = new Fish(i, j, fishDir, true);
			}
		}
		
		int first = fishMap[0][0];
		int answer = first;
		//상어는 0,0 물고기를 먹고 시작
		shark = new Fish(0, 0, fishes[first].d);
		fishMap[0][0] = -1;
		fishes[first].isAlive = false;
		return answer;
	}
	
	private static void dfs(Fish[] fishes, int[][] fishMap, int answer) {
		// 1. 물고기 이동
		moveFish(fishes, fishMap);
		
		// 2. 상어 이동
		// 상어가 움직일 수 있는 자리 확인하기
		List<int[]> next = moveSharkNext(fishMap);
		
		if (next.size() == 0) {//상어가 더 이상 움직일 수 없다면 끝
			max = Math.max(max, answer);
			return;
		} else {//상어가 움직일 수 있는 위치가 있다면
			int sx = shark.x;
			int sy = shark.y;
			int sd = shark.d;
			
			for (int[] p : next) {//상어가 움직일 수 있는 좌표마다 맵 복사, dfs
				int[][] tempFishMap = new int[4][4];
				Fish[] tempFish = new Fish[17];
				
				//맵 복사
				for (int i = 0; i < 4; i++) {
					System.arraycopy(fishMap[i], 0, tempFishMap[i], 0, 4);
				}
				//물고기 복사
				for (int i = 1; i < 17; i++) {
					tempFish[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].d, fishes[i].isAlive);
				}
				
				int nextX = p[0];
				int nextY = p[1];
				int nextFishNum = fishMap[nextX][nextY];
				
				//상어 이동
				fishMap[sx][sy] = 0;
				fishMap[nextX][nextY] = -1;
				fishes[nextFishNum].isAlive = false;
				shark = new Fish(nextX, nextY, fishes[nextFishNum].d);
				
				dfs(fishes, fishMap, answer+nextFishNum);
				
				//상어 원위치
				fishMap[sx][sy] = -1;
				fishMap[nextX][nextY] = nextFishNum;
				fishes[nextFishNum].isAlive = true;
				shark = new Fish(sx, sy, sd);
				
				//맵 원위치
				for (int i = 0; i < 4; i++) {
					System.arraycopy(tempFishMap[i], 0, fishMap[i], 0, 4);
				}
				//물고기 복구
				for (int i = 1; i < 17; i++) {
					fishes[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].d, tempFish[i].isAlive);
				}
			}
		}
	}
	
	private static void moveFish(Fish[] fishes, int[][] fishMap) {
		for (int i = 1; i <= 16; i++) {
			//죽은 물고기는 패스
			if (!fishes[i].isAlive) continue;
			
			//현재 방향에 물고기 또는 빈칸이 있다면 그 방향으로 이동
			int curX = fishes[i].x;
			int curY = fishes[i].y;
			int nowDir = fishes[i].d;
			
			int nx = curX + dx[nowDir];
			int ny = curY + dy[nowDir];
			
			boolean canMove = true;
			if (!canFishMove(fishMap, nx, ny)) {//물고기가 움직일 수 없다면 8방향 탐색해서 찾기
				for (int j = 0; j < 8; j++) {
					nx = curX + dx[(nowDir+j)%8];
					ny = curY + dy[(nowDir+j)%8];
					
					if (canFishMove(fishMap, nx, ny)) {//갈 수 있는 방향을 찾았으면 해당 방향 저장
						nowDir = (nowDir+j)%8;
						canMove = true;
						break;
					}
					canMove = false;
				}
			}
			//8방향을 다 찾았는데도 움직일 수 없다면 그자리 그대로 고정
			if (!canMove) continue;
			
			//물고기 움직이기
			moveNext(fishes, fishMap, i, curX, curY, nowDir);
		}
	}

	private static boolean canFishMove(int[][] fishMap, int nx, int ny) {
		return nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && fishMap[nx][ny] != -1;
	}
	
	private static void moveNext(Fish[] fishes, int[][] fishMap, int fishNum, int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		fishes[fishNum] = new Fish(nx, ny, d, true);
		
		if (fishMap[nx][ny] != 0) {//움직이는 위치에 다른 물고기가 있다면 둘의 위치 바꿔주기
			switchFish(fishes, fishMap, fishNum, fishMap[nx][ny], x, y, nx, ny);
		} else {//빈칸이라면
			fishMap[x][y] = 0;
			fishMap[nx][ny] = fishNum;
		}
	}

	private static void switchFish(Fish[] fishes, int[][] fishMap, int moveFish, int nextFish, int x, int y, int nx, int ny) {
		//맵 정보 먼저 바꾸기
		int temp = fishMap[x][y];
		fishMap[x][y] = fishMap[nx][ny];
		fishMap[nx][ny] = temp;
		
		//서로 Fish객체의 정보 바꾸기
		fishes[nextFish] = new Fish(x, y, fishes[nextFish].d, true);
	}
	
	private static List<int[]> moveSharkNext(int[][] fishMap) {
		List<int[]> point = new ArrayList<>();	
		int cx = shark.x;
		int cy = shark.y;
		
		while (true) {//상어가 갈 수 있는 다음 위치 찾기
			int nx = cx + dx[shark.d];
			int ny = cy + dy[shark.d];
			
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
			if (fishMap[nx][ny] == 0) {
				cx = nx;
				cy = ny;
				continue;
			}
			point.add(new int[] {nx, ny});
			cx = nx;
			cy = ny;
		}
		return point;
	}
	

}
