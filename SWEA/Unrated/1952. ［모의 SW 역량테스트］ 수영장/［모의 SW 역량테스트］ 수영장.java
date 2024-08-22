import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, result;
    static int[] price = new int[4];;
    static int[] month = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }
            result = Integer.MAX_VALUE;
            sb = new StringBuilder();
            dfs(0, 0);
            result = Math.min(result, price[3]);
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb.toString());
        }
        br.close();
    }
    static void dfs(int index, int sum){
        if(result < sum) return;
        if(index >= 12){
            result = Math.min(result, sum);
            return;
        }

        if(month[index] * price[0] > price[1])
            dfs(index + 1, sum + price[1]);
        else
            dfs(index + 1, sum + month[index] * price[0]);
        if(index < 10){
            dfs(index + 3, sum + price[2]);
        }
    }
}
