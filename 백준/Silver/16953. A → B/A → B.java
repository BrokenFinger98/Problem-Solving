import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long A, B;
    static int cnt;
    static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        set.add(A);

        Queue<Long> q = new ArrayDeque<>();
        q.offer(A);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long now = q.poll();
                if (now == B) {
                    System.out.println(cnt + 1);
                    System.exit(0);
                }
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        if (now * 2 > B) continue;
                        if (!set.contains(now*2)) {
                            set.add((long) (now * 2));
                            q.offer(now * 2);
                        }
                    } else {
                        if (now * 10 + 1 > B) continue;
                        if (!set.contains(now * 10 + 1)) {
                            set.add((long) (now * 10 + 1));
                            q.offer(now * 10 + 1);
                        }
                    }
                }
            }
            ++cnt;
        }

        System.out.println(-1);
        br.close();
    }
}
