import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M, K;
    static long[] tree;
    static long[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new long[N+1];
        input = new long[N+1];
        for (int i = 1; i <= N; i++) {
            input[i] = Long.parseLong(br.readLine());
            update(tree, i, input[i]);
        }
        M += K;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                long dif = c - input[b];
                input[b] = c;
                update(tree, b, dif);
            }else{
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long totalSum = sum(tree, c) - sum(tree, b-1);
                sb.append(totalSum).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static long sum(long[] tree, int i) {
        long answer = 0;
        while (i > 0){
            answer += tree[i];
            i -= (i & -i);
        }
        return answer;
    }

    private static void update(long[] tree, int i, long dif) {
        while (i < tree.length){
            tree[i] += dif;
            i += (i & -i);
        }
    }
}
