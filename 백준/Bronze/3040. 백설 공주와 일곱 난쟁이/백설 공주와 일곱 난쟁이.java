import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int[] input = new int[9];
    static int[] output = new int[2];
    static boolean[] result = new boolean[9];
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; ++i){
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        sum -= 100;
        for(int i = 0; i < 9; ++i){
            for(int j = i + 1; j < 9; ++j){
                if(sum == input[i] + input[j]){
                    result[i] = true;
                    result[j] = true;
                }
            }
        }

        for(int i = 0; i < 9; ++i){
            if(result[i]) continue;
            System.out.println(input[i]);
        }

    }
//    static void combi(int depth, int start){
//        if(depth == 2){
//            int sum = 0;
//            for(int i = 0; i < depth; ++i){
//                sum -= output[i];
//            }
//            if(sum == 0){
//
//            }
//        }
//    }
}