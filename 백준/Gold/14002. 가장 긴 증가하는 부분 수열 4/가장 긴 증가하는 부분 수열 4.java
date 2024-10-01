import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, answer = 1, idx;
    static int[] prevList;
    static List<Integer> result = new ArrayList<>();
    static int[] dp;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new int[N];
        prevList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            prevList[i] = -1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(num[j] < num[i] && dp[i] < dp[j] +1){
                    dp[i] = dp[j] + 1;
                    prevList[i] = j;
                    if(answer < dp[i]){
                        answer = dp[i];
                        idx = i;
                    }
                }
            }
        }
        sb.append(answer).append("\n");
        for (int i = idx; i != -1; i = prevList[i]) {
            result.add(num[i]);
        }
        Collections.reverse(result);
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

