import java.io.*;
import java.util.StringTokenizer;

/**
 * 	시간 : 169ms, 메모리 : 20,440KB
 */

class Solution {
    static int T, N, B, S, result;
    static int[] height;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            S = 0;
            result = Integer.MAX_VALUE;
            numbers = new int[N];
            height = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            generateSubset(0, 0);

            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb.toString());
        }
    }
    static void generateSubset(int depth, int len){
        if(depth == N){
            if(len < 1) return;
            int sum = 0;
            for(int i = 0; i < len; ++i){
                sum += numbers[i];
            }
            if(sum >= B){
                result = Math.min(result, Math.abs(B - sum));
            }
            return;
        }
        numbers[len] = height[depth];
        generateSubset(depth + 1, len + 1);
        generateSubset(depth + 1, len);
    }
}