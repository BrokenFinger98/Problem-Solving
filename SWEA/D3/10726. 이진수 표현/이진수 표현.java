import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static int flag;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            flag = 0;
            s = Integer.toBinaryString(M);
            boolean on = true;
            if(N > s.length()){
                sb.append("OFF");
                System.out.println(sb.toString());
                continue;
            }
            for (int i = 0; i < N; i++) {
                if(s.charAt(s.length() - 1 - i) != '1'){
                    on = false;
                    break;
                }
            }
            if (on) {
                sb.append("ON");
            } else {
                sb.append("OFF");
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
