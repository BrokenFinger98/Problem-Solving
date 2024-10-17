import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long a, b, c, A, B, C;
    static int N;
    static long[] input;
    static long result = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        input = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(input);

        for (int k = 0; k < N - 1; k++) {
            int i = k + 1;
            int j = N - 1;
            c = input[k];

            while (i < j) {
                if(i == k) {
                    ++i;
                }
                if(j == k) {
                    --j;
                    continue;
                }

                long currentSum = input[i] + input[j] + c;

                if (Math.abs(currentSum) < result) {
                    result = Math.abs(currentSum);
                    a = input[i];
                    b = input[j];
                    A = a;
                    B = b;
                    C = c;
                }
                if (currentSum > 0) --j;
                else ++i;
            }
        }

        List<Long> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        Collections.sort(list);

        for (Long num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
/*
<케이스>

6
-104336608 239510944 997686289 627058077 722156401 -942278495
<답>

-942278495 239510944 722156401

<케이스>

7
912022275 -968846127 195376182 -212509759 589371385 817446019 -59843192

<답>

-968846127 195376182 817446019
 */