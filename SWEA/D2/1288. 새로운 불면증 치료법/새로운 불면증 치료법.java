import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T;
    static int result;
    static int N;
    static long M;
    static int flag, now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < 10; ++i){
            flag = flag | 1 << i;
        }
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            M = 0;
            result = 0;
            now = 0;
            while ((now | flag) != now) {
                ++result;
                M = N * result;
                for(long i = M; i > 0; i /= 10){
                    if((now & 1 << i % 10) != 0) continue;
                    now = now | 1 << i%10;
                }
            }
            sb.append("#").append(t).append(" ").append(N * result);
            System.out.println(sb.toString());
        }
    }
}
