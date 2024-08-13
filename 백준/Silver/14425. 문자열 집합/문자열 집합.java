import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; ++i){
            set.add(br.readLine());
        }

        for(int i = 0; i < M; ++i){
            if (set.contains(br.readLine())) {
                ++result;
            }
        }
        System.out.println(result);
        br.close();
    }
}