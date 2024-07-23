import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        check[0] = true;
        check[1] = true;
        for (int i = 2; i*i<=N; i++) {
            if(!check[i]){
                for(int j = i+i; j <= N; j+=i) {
                    check[j] = true;
                }
            }
        }

        for(int i = M; i <= N; i++) {
            if(!check[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
