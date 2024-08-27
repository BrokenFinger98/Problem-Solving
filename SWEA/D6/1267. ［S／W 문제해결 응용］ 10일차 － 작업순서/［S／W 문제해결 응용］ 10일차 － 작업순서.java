import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class Solution {
    static int T = 10;
    static int V, E;
    static List<Integer> result;
    static List<Integer>[] list;
    static int[] inDegree;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            queue = new ArrayDeque<>();
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new List[V+1];
            inDegree = new int[V + 1];
            result = new ArrayList<>();
            for (int i = 1; i < V+1; i++) {
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; ++i){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                inDegree[to]++;
            }
            for (int i = 1; i < V+1; i++) {
                if(inDegree[i] == 0) queue.offer(i);
            }

            while (!queue.isEmpty()){
                int now = queue.poll();
                result.add(now);
                for (Integer i : list[now]) {
                    inDegree[i]--;
                    if(inDegree[i] == 0) queue.offer(i);
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
