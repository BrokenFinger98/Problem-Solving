import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 2) {
            System.out.println(0);
            return;
        }

        boolean[] check = new boolean[N + 1];
        check[0] = check[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; ++i) {
            if (!check[i]) {
                for (int j = i * i; j <= N; j += i) { // 미세 최적화: i*i부터 시작
                    check[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; ++i) if (!check[i]) primes.add(i);

        long sum = 0;
        int answer = 0;
        int left = 0, right = 0;

        while (true) {
            if (sum >= N) {
                sum -= primes.get(left++);
            } else {
                if (right == primes.size()) break; // 더 늘릴 수 없으면 종료
                sum += primes.get(right++);
            }
            if (sum == N) answer++;
        }

        System.out.println(answer);
    }
}