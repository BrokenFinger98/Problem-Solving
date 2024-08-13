import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {
    static int T;
    static int[] ku = new int[9];
    static int[] in = new int[9];
    static boolean[] check;
    static int winCnt, loseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; ++t){
            sb = new StringBuilder();
            check = new boolean[19];
            winCnt = 0;
            loseCnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; ++i){
                ku[i] = Integer.parseInt(st.nextToken());
                check[ku[i]] = true;
            }
            int j = 0;
            for(int i = 1; i <= 18;  ++i){
                if(!check[i]) in[j++] = i;
            }
            Arrays.sort(in);

            do {
                int kuScore = 0;
                int inScore = 0;
                for(int i = 0; i < 9; ++i){
                    if(ku[i] > in[i]) kuScore += ku[i] + in[i];
                    else if(in[i] > ku[i]) inScore += ku[i] + in[i];
                }
                if(kuScore > inScore){
                    winCnt++;
                }else if(inScore > kuScore){
                    loseCnt++;
                }
            }while (next_permutation());

            sb.append("#").append(t).append(" ").append(winCnt).append(" ").append(loseCnt);
            System.out.println(sb.toString());
        }
    }
    static boolean next_permutation(){
        int i = in.length - 1;
        int j = in.length - 1;

        while (i > 0 && in[i-1] >= in[i]) --i;
        if(i <= 0) return false;

        while (in[i-1] > in[j]) --j;
        swap(i-1, j);

        j = in.length-1;
        for(; i < j; ++i, --j){
            swap(i, j);
        }
        return true;
    }
    static void swap(int a, int b){
        int temp = in[a];
        in[a] = in[b];
        in[b] = temp;
    }
}