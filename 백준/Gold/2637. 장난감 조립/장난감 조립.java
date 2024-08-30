import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M, from, to, weight;
    static List<Node>[] list;
    static int[] result;
    static Queue<Node> queue = new ArrayDeque<>();
    static int[] inDegree;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        N = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        inDegree = new int[N + 1];
        count = new int[N + 1];
        result = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
            inDegree[to]++;
        }

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0) queue.offer(new Node(i, 1));
        }

        count[N] = 1;
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(list[now.to].isEmpty()){
                result[now.to] = count[now.to];
                continue;
            }
            for (Node node : list[now.to]) {
                count[node.to] += count[now.to] * node.weight;
                if(--inDegree[node.to] == 0){
                    queue.offer(node);
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if(result[i] == 0) continue;
            sb = new StringBuilder();
            sb.append(i).append(" ").append(result[i]);
            System.out.println(sb.toString());
        }

        br.close();
    }
}