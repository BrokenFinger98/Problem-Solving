import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, a, b;
    static int[] input;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N*4][2];
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        init(0, N-1, 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int[] result = query(0, N-1, 1, a-1, b-1);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static int[] query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return new int[]{1_000_000_000, 1};
        if(left <= start && right >= end) return new int[]{tree[node][0], tree[node][1]};
        int mid = (start + end) / 2;
        int leftChild[] = query(start, mid, node * 2, left, right);
        int rightChild[] = query(mid + 1, end, node * 2 + 1, left, right);
        return new int[]{Math.min(leftChild[0], rightChild[0]), Math.max(leftChild[1], rightChild[1])};
    }

    static void init(int start, int end, int node){
        if(start == end) {
            tree[node][0] = input[start];
            tree[node][1] = input[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node][0] = Math.min(tree[node*2][0], tree[node*2 + 1][0]);
        tree[node][1] = Math.max(tree[node*2][1], tree[node*2 + 1][1]);
    }
}
