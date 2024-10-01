import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            index = lowerBound(num);
            if(dp[index] == 0) ++answer;
            dp[index] = num;
        }
        System.out.println(answer);
        br.close();
    }

    static int lowerBound(int num) {
        int low = 0;
        int height = answer;
        int mid;
        while(low < height){
            mid = (low + height)/2;
            if(dp[mid] < num)
                low = mid + 1;
            else
                height = mid;
        }
        return low;
    }

}

