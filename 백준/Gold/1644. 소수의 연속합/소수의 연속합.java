import java.util.*;
import java.io.*;

public class Main {
    static int N;

    // 해당 인덱스가 소수이면 false, 아니면 true를 저장하는 배열
    // boolean의 default값은 false이기 때문에
    static boolean[] checkPrime;

    // 소수를 저장하는 배열
    static int[] prime = new int[400004];
    static int L, R;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // N까지 소수 일 수 있으므로 N+1 사이즈로 배열 생성
        checkPrime = new boolean[N+1];

        // 0, 1은 소수가 아님
        checkPrime[0] = true;
        checkPrime[1] = true;

        for(int i = 2; i * i <= N; ++i){
            if(!checkPrime[i]){
                for(int j = i + i; j <= N; j += i)
                    checkPrime[j] = true;
            }
        }

        int k = 1;
        for(int i = 2; i <= N; ++i){
            if(!checkPrime[i]){
                prime[k] = prime[k-1] + i;
                ++k;
            }
        }

        L = 0;
        R = 1;
        int sum = 0;
        int result = 0;
        while (true){
            if(R <= L || R >= k){
                break;
            }
            sum = prime[R] - prime[L];
            if(sum < N) ++R;
            else if(sum > N) ++L;
            else{
                result++;
                ++R;
                ++L;
            }
        }
        bw.write(Integer.toString(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}