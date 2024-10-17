import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] graph;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        size = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }

        countSubtreeNodes(R, -1);

        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(size[node]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void countSubtreeNodes(int currentNode, int parent) {
        size[currentNode] = 1;
        for (int nextNode : graph[currentNode]) {
            if (nextNode != parent) {
                countSubtreeNodes(nextNode, currentNode);
                size[currentNode] += size[nextNode];
            }
        }
    }
}
