import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, num, answer, index;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        st = new StringTokenizer(br.readLine());

        dp[0] = Integer.parseInt(st.nextToken());
        answer = 1;
        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            index = Arrays.binarySearch(dp, 0, answer, num);
            if (index < 0) index = -(index + 1);
            dp[index] = num;
            if(index == answer) ++answer;
        }
        System.out.println(answer);
        br.close();
    }
}

