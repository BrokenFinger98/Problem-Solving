import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s1, s2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length()][s2.length()];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < s2.length(); i++) {
            if(s2.charAt(i) == s1.charAt(0)){
                dp[0][i] = 1;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[s1.length()-1][s2.length()-1]);
        br.close();
    }
}

