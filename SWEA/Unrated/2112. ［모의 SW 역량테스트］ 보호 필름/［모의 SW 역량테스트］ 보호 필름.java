import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *	시간 : 217ms, 메모리 : 36,640KB
 */
public class Solution {

    static int T, D, W, K, result;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; ++t) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new boolean[D][W];
            result = K;
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = st.nextToken().equals("1");
                }
            }
            subset(0, 0);
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb.toString());
        }
        br.close();
    }
    static void subset(int depth, int cnt){
        if(cnt >= result) return;
        if(depth == D){
            if(check()) result = Math.min(result, cnt);
            return;
        }

        boolean[] temp = Arrays.copyOf(map[depth], W);

        subset(depth + 1, cnt);

        Arrays.fill(map[depth], true);
        subset(depth + 1, cnt + 1);

        Arrays.fill(map[depth], false);
        subset(depth + 1, cnt + 1);

        map[depth] = temp;
    }

    static boolean check(){
        for (int j = 0; j < W; j++) {
            int maxCnt = 0;
            int cnt = 1;
            for (int i = 1; i < D; i++) {
                if(map[i][j] == map[i-1][j]) ++cnt;
                else{
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 1;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
            if(maxCnt < K) return false;
        }
        return true;
    }
}
