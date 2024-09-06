import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *  시간 : 110ms, 메모리 : 19,180KB
 */
public class Solution {
    static int T, N, K;
    static String input, temp;
    static TreeSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            set = new TreeSet<>();

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            input = br.readLine();
            for (int i = 0; i < N/4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp = input.substring(j*(N/4), (j+1)*(N/4));
                    set.add(Integer.parseInt(temp, 16));
                }
                input = input.charAt(N-1) + input.substring(0, N-1);
            }

            while (K > 1){
                set.pollLast();
                --K;
            }
            sb.append("#").append(t).append(" ").append(set.pollLast());
            System.out.println(sb.toString());
        }
    }
}
