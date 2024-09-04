import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static int[] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        counts = new int[10001];
        counts[0] = 1;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j < 10001; j++) {
                if(j - i >= 0) counts[j] += counts[j-i];
            }
        }
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(counts[N]);
        }
        br.close();
    }
}
