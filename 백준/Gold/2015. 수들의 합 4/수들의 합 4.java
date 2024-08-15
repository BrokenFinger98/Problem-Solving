import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int N, K;
    static long result;
    static int[] prefix;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        prefix = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i){
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        map.put(0, 1);
        for(int i = 1; i <= N; ++i){
            result += map.getOrDefault(prefix[i] - K, 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0)+1);
        }

        System.out.println(result);
        br.close();
    }
}