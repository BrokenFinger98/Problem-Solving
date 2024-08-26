import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] input;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        input = new int[(int)Math.pow(2, K) - 1];
        tree = new List[(int)Math.pow(2, K) - 1];
        for (int i = 0; i < tree.length; ++i) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        makeTree(0, (int)Math.pow(2, K) - 1, 0);

        for (int i = 0; i < K; ++i) {
            for (Integer integer : tree[i]) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        br.close();
    }

    static void makeTree(int from, int to, int depth) {
        if (depth == K) return;
        tree[depth].add(input[(to - from) / 2 + from]);
        makeTree(from, (to - from) / 2 + from, depth + 1);
        makeTree((to - from) / 2 + from, to, depth + 1);
    }
}
