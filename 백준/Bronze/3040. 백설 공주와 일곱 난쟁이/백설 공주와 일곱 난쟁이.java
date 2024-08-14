import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int[] input = new int[9];
    static int[] index = new int[2];
    static boolean[] result = new boolean[9];
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; ++i){
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        sum -= 100;

        combi(0, 0);

        for(int i = 0; i < 9; ++i){
            if(result[i]) continue;
            System.out.println(input[i]);
        }

    }
    static void combi(int depth, int start){
        if(depth == 2){
            if(sum == input[index[0]] + input[index[1]]){
                result[index[0]] = true;
                result[index[1]] = true;
            }
            return;
        }
        for(int i = start; i < 9; ++i){
            index[depth] = i;
            combi(depth+1, i+1);
        }
    }
}