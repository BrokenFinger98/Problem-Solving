import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int N;
    static long result, sum;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; ++i) {
            pq.offer(Long.parseLong(new StringTokenizer(br.readLine()).nextToken()));
        }

        while (pq.size() > 1) {
            sum = pq.poll() + pq.poll();
            pq.offer(sum);
            result += sum;
        }
        System.out.println(result);
        br.close();
    }
}