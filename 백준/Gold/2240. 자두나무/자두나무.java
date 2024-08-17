import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int T, W;
    static int[][][] dp = new int[1004][2][34];
    static int[] fruit = new int[1004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0 ; j < dp[i].length; ++j){
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < T; ++i) {
            fruit[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(Math.max(go(0, 1, W-1), go(0, 0, W)));
        br.close();
    }
    static int go(int index, int tree, int cnt){
        if(cnt < 0) return Integer.MIN_VALUE;
        if(index == T) return 0;
        if(dp[index][tree][cnt] != -1) return dp[index][tree][cnt];

        int stay = go(index + 1, tree, cnt);
        int move = go(index + 1, tree ^ 1, cnt - 1);

        dp[index][tree][cnt] = Math.max(stay, move) + (tree == fruit[index] - 1 ? 1 : 0);
        return dp[index][tree][cnt];
    }
}