import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 171ms, 메모리 : 25,076KB
 */
public class Solution {
    static int T = 10;
    static int N, S, from, to, answer;
    static Queue<Integer> queue;
    static boolean[] visited;
    static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            visited = new boolean[101];
            lists = new List[101];
            queue = new ArrayDeque<>();
            for (int i = 1; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; i++) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                lists[from].add(to);
            }
            bfs();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }
    static void bfs(){
        visited[S] = true;
        queue.offer(S);
        while (!queue.isEmpty()){
            int size = queue.size();
            answer = 0;
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                answer = Math.max(answer, now);
                for (Integer next : lists[now]) {
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
