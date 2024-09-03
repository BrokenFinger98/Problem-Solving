
/*
8 3
0 0 0 0 0 1 0 0
0 1 0 1 0 0 0 1
0 0 0 0 0 0 0 0
0 0 0 1 0 1 0 0
0 0 1 1 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 1 0 1 0
1 0 0 0 0 0 0 0
 */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[][] map;
	static ArrayList<int[]> houses;
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			houses = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) houses.add(new int[] {i, j});
				}
			}
			
			int rev=0, tmp;
			for (int k = 21; k >=1 ; k--) {
				if((tmp=getRev(k))>rev) rev = tmp;
			}
			sb.append('#').append(tc).append(' ').append(rev).append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static int getRev(int k) {
		int count = 0, maxCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = 0;
				for (int[] house: houses) {
					int distance = Math.abs(house[0] - i) + Math.abs(house[1] - j);
					if(distance < k) count++;
				}
				if(count > maxCount) {
					// 수익이 난다면
					if(count*M >= k*k+(k-1)*(k-1))
						
					// 갱신
					maxCount = count;
				}
			}
		}
		
		 
		return maxCount;
	}

}
