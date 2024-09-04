import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static int[] counts;
    static int answer, kinds;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        counts = new int[d];
        counts[c-1] = 1;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine()) - 1;
        }
        kinds = 1;
        for (int i = 0; i < k; i++) {
            if(++counts[sushi[i]] == 1) ++kinds;
        }
        answer = kinds;
        for (int i = k; i < N+k; i++) {
            if(--counts[sushi[(i-k)%N]] == 0) kinds--;
            if(++counts[sushi[i%N]] == 1) kinds++;
            answer = Math.max(answer, kinds);
        }

        System.out.println(answer);
        br.close();
    }
}
