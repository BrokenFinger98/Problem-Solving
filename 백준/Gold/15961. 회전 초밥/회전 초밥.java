import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static int answer;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }
        answer = map.containsKey(c) ? map.size() : map.size() + 1;

        for (int i = k; i < N+k; i++) {
            if(map.containsKey(sushi[(i-k)%N])){
                if(map.get(sushi[(i-k)%N]) == 1)
                    map.remove(sushi[(i - k) % N]);
                else map.put(sushi[(i - k) % N], map.get(sushi[(i - k) % N]) - 1);
            }
            if(map.containsKey(sushi[i%N])){
                map.put(sushi[i % N], map.get(sushi[i % N]) + 1);
            }else{
                map.put(sushi[i % N], 1);
            }
            answer = Math.max(answer, map.containsKey(c) ? map.size() : map.size() + 1);
        }
        System.out.println(answer);
        br.close();
    }
}
