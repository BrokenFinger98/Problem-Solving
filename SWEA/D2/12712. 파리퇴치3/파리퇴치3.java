import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int go(int[][] A, int N, int M){
        int ret = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; ++j){
                ret = Math.max(ret, Math.max(go1(A, i, j, N, M), go2(A, i, j, N, M)));
            }
        }
        return ret;
    }
    public static int go1(int[][] A, int y, int x, int N, int M){
        int ret = A[y][x];
        for(int i = 1; i < M; ++i){
            if(y-i >= 0) ret += A[y-i][x];
            if(y+i < N) ret += A[y+i][x];
            if(x-i >= 0) ret += A[y][x-i];
            if(x+i < N) ret += A[y][x+i];
        }
        return ret;
    }
    public static int go2(int[][] A, int y, int x, int N, int M){
        int ret = A[y][x];
        for(int i = 1; i < M; ++i){
            if(y-i >= 0 && x-i >= 0) ret += A[y-i][x-i];
            if(y-i >= 0 && x+i < N) ret += A[y-i][x+i];
            if(y+i < N && x-i >= 0) ret += A[y+i][x-i];
            if(y+i < N && x+i < N) ret += A[y+i][x+i];
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; ++i){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] A = new int[15][15];

            for(int j = 0; j < N; ++j){
                for(int k = 0; k < N; ++k){
                    A[j][k] = sc.nextInt();
                }
            }
            System.out.println("#" + i + " " + go(A, N, M));
        }
        sc.close();
    }
}
