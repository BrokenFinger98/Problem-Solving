import java.io.*;
import java.util.*;

class Pair{
    int score, cal;
    Pair(int score, int cal) {
        this.score = score;
        this.cal = cal;
    }
}
class Solution {
    static int N, L, max;
    static Pair[] pair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; ++i) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = 0;
            pair = new Pair[N];
            for(int j = 0; j < N; ++j) {
                st = new StringTokenizer(br.readLine());
                pair[j] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            dfs(0, 0, 0);
            bw.write("#" + i + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int idx, int s, int c){
        if(c > L) return;
        if(idx == N){
            if(c <= L) max = Math.max(max, s);
            return;
        }
        dfs(idx + 1, s + pair[idx].score, c + pair[idx].cal);
        dfs(idx + 1, s, c);
    }
}