import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static String s1, s2;
    static int[][] dp;
    static ArrayDeque<Character> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int y = s1.length();
        for (int j = s2.length(); j > 0; j--) {
            if(dp[y][j] > dp[y][j-1] && dp[y][j] == dp[y-1][j-1] + 1){
                if(s1.charAt(y-1) == s2.charAt(j-1)) {
                    stack.push(s2.charAt(j - 1));
                }else{
                    ++j;
                }
                y--;
            }
        }
        sb.append(dp[s1.length()][s2.length()]).append("\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
        br.close();
    }
}

