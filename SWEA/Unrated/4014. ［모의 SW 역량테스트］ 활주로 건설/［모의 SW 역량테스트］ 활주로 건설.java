import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, X, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            answer = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                int[] load1 = new int[N];
                int[] load2 = new int[N];
                for (int j = 0; j < N; j++) {
                    load1[j] = map[i][j];
                    load2[j] = map[j][i];
                }
                answer += canConstruct(load1) ? 1 : 0;
                answer += canConstruct(load2) ? 1 : 0;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static boolean canConstruct(int[] load) {
        boolean[] installed = new boolean[N]; // 경사로 설치 여부를 기록할 배열

        for (int i = 0; i < N - 1; i++) {
            if (load[i] == load[i + 1]) continue; // 높이가 같으면 넘어간다

            if (Math.abs(load[i] - load[i + 1]) > 1) return false; // 높이 차이가 1보다 크면 불가능

            // 하강 경사로 설치 (i -> i+X)
            if (load[i] > load[i + 1]) {
                for (int j = i + 1; j <= i + X; j++) {
                    if (j >= N || load[i + 1] != load[j] || installed[j]) return false; // 경사로 설치 불가 조건
                    installed[j] = true;
                }
            }
            // 상승 경사로 설치 (i-X+1 -> i)
            else {
                for (int j = i; j > i - X; j--) {
                    if (j < 0 || load[i] != load[j] || installed[j]) return false; // 경사로 설치 불가 조건
                    installed[j] = true;
                }
            }
        }
        return true;
    }
}
