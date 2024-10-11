import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] inDegree;
    static int N, M;
    static List<Integer>[] graph;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        inDegree = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to]++;
        }
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) pq.offer(i);
        }
        while (!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");
            for (Integer i : graph[now]) {
                if(--inDegree[i] == 0)
                    pq.offer(i);
            }
        }
        System.out.print(sb);
        br.close();
    }
}

