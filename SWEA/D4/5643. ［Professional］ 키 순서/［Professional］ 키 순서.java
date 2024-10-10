import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int T, N, M, from, to, answer;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            dist = new int[N+1][N+1];

            for (int i = 0; i <= N; i++) {
                Arrays.fill(dist[i], 1000);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                dist[from][to] = 1;
            }
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                int cnt = 1;
                for (int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if(dist[j][i] != 1000) ++cnt;
                    if(dist[i][j] != 1000) ++cnt;
                }
                if(cnt == N) ++answer;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
