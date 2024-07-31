import java.util.*;
import java.io.*;

public class Main {
    static int N;

    // 해당 인덱스가 소수이면 false, 아니면 true를 저장하는 배열
    // boolean의 default값은 false이기 때문에
    static boolean[] checkPrime;

    // 소수를 저장하는 배열
    static List<Integer> prime = new ArrayList<>();
    static int L, R;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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

        for(int i = 2; i <= N; ++i){
            if(!checkPrime[i])
                prime.add(i);
        }

        int sum = 0;
        int result = 0;
        int L = 0, R = 0;
        while (true){
            if(sum >= N){
                sum -= prime.get(L);
                ++L;
            }else if(R == prime.size()){
                break;
            }else{
                sum += prime.get(R);
                ++R;
            }
            if(sum == N){
                result++;
            }
        }

        sb.append(result);
        System.out.println(sb.toString());
        br.close();
    }
}