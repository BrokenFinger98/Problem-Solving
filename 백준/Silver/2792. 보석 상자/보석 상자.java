import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max, answer = Integer.MAX_VALUE;
    static int[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewels = new int[M];
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }
        int low = 1;
        int hi = max;
        int mid;
        while (low <= hi){
            mid = (low + hi) / 2;
            if(check(mid)){
                answer = Math.min(answer, mid);
                hi = mid - 1;
            }else low = mid + 1;
        }
        System.out.println(answer);
        br.close();
    }
    static boolean check(int mid){
        int num = 0;
        for (int i = 0; i < M; i++) {
            num += jewels[i]/mid;
            if(jewels[i]%mid != 0) ++num;
        }
        return N >= num;
    }
}

