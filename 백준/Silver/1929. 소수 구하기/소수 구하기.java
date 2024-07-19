import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> ret = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        for(int i = M; i <= N; ++i) a.add(i);

        for (int i = 0; i < a.size(); i++) {
            if (checkPrime(a.get(i))) ret.add(a.get(i));
        }
        for (Integer a : ret) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean checkPrime(int p){
        if(p < 2) return false;
        for (int i = 2; i*i <= p ; i++) {
            if(p % i == 0) return false;
        }
        return true;
    }
}
