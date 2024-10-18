import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 572ms, 메모리 : 209,472KB
 */
public class Main {
    static int N, M, a, b;
    static int[] input;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N*4];
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        init(0, N-1, 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int result = query(0, N-1, 1, a-1, b-1);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static int query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 1_000_000_000;
        if(left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
    }

    static int init(int start, int end, int node){
        if(start == end) return tree[node] = input[start];
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }
}
