import java.io.*;
import java.lang.*;
import java.util.*;

class Pair{
    int sour;
    int bitter;
    public Pair(int sour, int bitter){
        this.sour = sour;
        this.bitter = bitter;
    }
}
public class Main {
    static int N;
    static int sour, bitter;
    static Pair[] ingredients;
    static int[] index;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ingredients = new Pair[N];
        index = new int[N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            sour = Integer.parseInt(st.nextToken());
            bitter = Integer.parseInt(st.nextToken());
            ingredients[i] = new Pair(sour, bitter);
        }

        generateSubset(0, 0);
        System.out.println(result);
        br.close();
    }
    static void generateSubset(int depth, int len){
        if(depth == N){
            if(len == 0) return;
            int sour = 1;
            int bitter = 0;
            for(int i = 0; i < len; ++i){
                sour *= ingredients[index[i]].sour;
                bitter += ingredients[index[i]].bitter;
            }
            result = Math.min(result, Math.abs(sour - bitter));
            return;
        }

        index[len] = depth;
        generateSubset(depth + 1, len + 1);
        generateSubset(depth + 1, len);
    }
}
