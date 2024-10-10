import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t, n;
    static int[][] position;
    static int[][] dist;
    static final int INF = 16_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        while (t > 0){
            --t;
            n = Integer.parseInt(br.readLine());
            position = new int[n+2][2];
            dist = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(dist[i], INF);
            }
            for (int i = 0; i < n+2; i++) {
                st = new StringTokenizer(br.readLine());
                position[i][0] = Integer.parseInt(st.nextToken());
                position[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    int distance = Math.max(position[i][0], position[j][0]) - Math.min(position[i][0], position[j][0])
                            + Math.max(position[i][1], position[j][1]) - Math.min(position[i][1], position[j][1]);
                    if(distance < 1001)
                        dist[i][j] = distance;
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            if(dist[0][n+1] != INF){
                sb.append("happy");
            }else sb.append("sad");
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
