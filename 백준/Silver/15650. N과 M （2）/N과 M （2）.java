import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 시간 : 1,264ms, 메모리 : 161,152KB
 */
public class Main {
    static int N, M;
    static int[] input;
    static int[] numbers;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = i+1;
        }
        isSelected = new boolean[N];
        numbers = new int[M];

        permutation(0, -1);
        br.close();
    }

    static void permutation(int depth, int start){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start+1; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            numbers[depth] = input[i];
            permutation(depth + 1, i);
            isSelected[i] = false;
        }
    }
}
