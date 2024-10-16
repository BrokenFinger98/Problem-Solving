import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] tree;
    static int[] input;
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new int[N];
        tree = new long[N * 4];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        init(0, N-1, 1);
        M += K;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                if(input[b-1] == 0){
                    input[b-1] = c;
                    init(0, N-1, 1);
                }else{
                    update(0, N-1, 1, b-1, c);
                    input[b-1] = c;
                }
            }else{
                sb.append(sum(0, N-1, 1, b-1, c-1)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 1;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return (sum(start, mid, node * 2, left, right) * sum(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    private static void update(int start, int end, int node, int index, int value) {
        if(start > index || end < index) return;
        tree[node] /= input[index];
        tree[node] *= value;
        tree[node] %= MOD;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, value);
        update(mid + 1, end, node * 2 + 1, index, value);
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }

    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = input[start];
        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }
}