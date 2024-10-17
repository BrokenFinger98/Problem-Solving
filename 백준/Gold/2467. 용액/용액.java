import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] asc;
    static int value = Integer.MAX_VALUE, a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        asc = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            asc[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        int j = N-1;
        while (i < j && i < N && j >= 0){
            if(value > Math.abs(asc[i] + asc[j])){
                value = Math.abs(asc[i] + asc[j]);
                a = asc[i];
                b = asc[j];
            }
            if(Math.abs(asc[i]) < Math.abs(asc[j])) --j;
            else ++i;
        }
        System.out.println(a + " " + b);
        br.close();
    }
}