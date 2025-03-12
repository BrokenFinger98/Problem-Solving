class Solution {
	static boolean[][] dp = new boolean[17][(1 << 17)-1];
	static int answer = 0;
	static int num;
	static int[] nodes;
	static int[][] edges;

	public int solution(int[] info, int[][] edgeInfo) {
		num = info.length;
		nodes = info;
		edges = edgeInfo;
		recursive(0, 1);
		return answer;
	}

	public void recursive(int node, int path) {
		if (dp[node][path]) {
			return;
		}
		dp[node][path] = true;

		int sheep = 0, wolf = 0;
		for (int i = 0; i < num; i++) {
			if ((path & (1 << i)) != 0) { 
				if (nodes[i] == 0) sheep++; 
				else wolf++; 
			}
		}

		if (wolf >= sheep) {
			return;
		}

		answer = Math.max(answer, sheep);

		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];

			if ((path & (1 << parent)) != 0 && (path & (1 << child)) == 0) {
				recursive(child, path | (1 << child));
			}
		}
	}
}
