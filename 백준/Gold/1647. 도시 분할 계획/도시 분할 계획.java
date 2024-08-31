import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 1,240ms, 메모리 : 321,084KB
 */
public class Main {
    static class Edge implements Comparable<Edge>{
        int A;
        int B;
        int C;

        public Edge(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.C, o.C);
        }
    }
    static int N, M, answer, A, B, C;
    static int[] parents;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(A, B, C));
        }
        int lastStreet = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            if(count == N-2) break;
            Edge edge = pq.poll();
            A = edge.A;
            B = edge.B;
            C = edge.C;
            if(find(A) != find(B)){
                union(A, B);
                answer += C;
                ++count;
                lastStreet = C;
            }
        }
        System.out.println(answer);
    }
    static void union(int A, int B){
        int pa = find(A);
        int pb = find(B);
        if(pa < pb) parents[pb] = pa;
        else parents[pa] = pb;
    }
    static int find(int v){
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
}
