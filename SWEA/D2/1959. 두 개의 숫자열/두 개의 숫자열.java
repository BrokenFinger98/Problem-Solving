import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, M;
    static int go(int[] A, int[] B) {
        int ret = 0;
        if (N > M) {
            for (int i = 0; i <= N - M; ++i) {
                int sum = 0;
                for (int j = 0; j < M; ++j) {
                    sum += A[i + j] * B[j];
                }
                ret = Math.max(ret, sum);
            }
        } else if (M > N) {
            for (int i = 0; i <= M - N; ++i) {
                int sum = 0;
                for (int j = 0; j < N; ++j) {
                    sum += A[j] * B[i + j];
                }
                ret = Math.max(ret, sum);
            }
        } else {
            for (int i = 0; i < N; ++i) {
                ret += A[i] * B[i];
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= T; ++i) {
            String[] nm = br.readLine().trim().split(" ");
            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);

            int[] A = new int[N];
            int[] B = new int[M];

            String[] aLine = br.readLine().trim().split(" ");
            for (int j = 0; j < N; ++j) {
                A[j] = Integer.parseInt(aLine[j]);
            }

            String[] bLine = br.readLine().trim().split(" ");
            for (int j = 0; j < M; ++j) {
                B[j] = Integer.parseInt(bLine[j]);
            }

            bw.write("#" + i + " " + go(A, B));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
