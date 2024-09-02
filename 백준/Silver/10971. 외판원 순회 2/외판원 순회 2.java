import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 128ms, 메모리 : 15,092KB
 */
public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] edges;
    static int[] vertexes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        vertexes = new int[n];
        edges = new int[n][n];

        for (int i = 0; i < n; i++) {
            vertexes[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do{
            int sum = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if(edges[vertexes[i]][vertexes[(i+1)%n]] == 0){
                    flag = false;
                    break;
                }
                sum += edges[vertexes[i]][vertexes[(i+1)%n]];
            }
            if(flag) answer = Math.min(answer, sum);
        }while (nextPermutation());

        System.out.println(answer);
        br.close();
    }
    static boolean nextPermutation(){
        int i, j, k;
        i = j = k = vertexes.length-1;
        while (i > 0 && vertexes[i-1] >= vertexes[i]) --i;
        if(i == 0) return false;
        while (vertexes[i-1]>=vertexes[j])--j;
        swap(i-1, j);
        while (i < k) swap(i++, k--);
        return true;
    }
    static void swap(int i, int j){
        int temp = vertexes[i];
        vertexes[i] = vertexes[j];
        vertexes[j] = temp;
    }
}
