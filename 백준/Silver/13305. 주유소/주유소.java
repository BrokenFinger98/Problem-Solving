
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] bridges = new int[N];
        for (int i = 1; i < N; i++) {
            bridges[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cities = new int[N + 1];
        int[] minimums = new int[N + 1];
        minimums[0] = Integer.MAX_VALUE;
        // 0, 5, 2, 2, 1
        // 0, 5, 2, 4, 1
        // 0, 2, 3, 1
        for (int i = 1; i <= N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; ++i) {
            minimums[i] = Math.min(minimums[i - 1], cities[i]);
        }

        long answer = 0;
        for (int i = 1; i < N; ++i) {
            answer += minimums[i] * bridges[i];
        }
        System.out.println(answer);
    }
}
