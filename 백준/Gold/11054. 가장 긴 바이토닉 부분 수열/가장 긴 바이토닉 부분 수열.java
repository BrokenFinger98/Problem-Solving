import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] num1;
    static int[] num2;
    static int[] increase;
    static int[] decrease;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        increase = new int[n];
        decrease = new int[n];
        num1 = new int[n];
        num2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
            num2[n-i-1] = num1[i];
        }
        for (int i = 0; i < n; i++) {
            increase[i] = 1;
            for (int j = 0; j < i; j++) {
                if(num1[i] > num1[j])
                    increase[i] = Math.max(increase[i], increase[j] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            decrease[i] = 1;
            for (int j = 0; j < i; j++) {
                if(num2[i] > num2[j])
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, increase[i] + decrease[n-i-1] - 1);
        }
        System.out.println(answer);
        br.close();
    }
}