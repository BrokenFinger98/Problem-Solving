import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] inDegree;
    static List<Integer>[] list;
    static Queue<Integer> queue = new ArrayDeque<>();
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        list = new List[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            inDegree[to]++;
        }
        
        for (int i = 1; i < inDegree.length; i++) {
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
        
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
