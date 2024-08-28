import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  시간 : 171ms, 메모리 : 25,076KB
 */
public class Solution {
    static int T, n, m, operator, a, b;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            parents = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                parents[i] = i;
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                operator = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if(operator == 0){
                    if(find(a) != find(b)){
                        union(a, b);
                    }
                }else{
                    if(find(a) == find(b)){
                        sb.append(1);
                    }else
                        sb.append(0);
                }
            }
            System.out.println(sb.toString());
        }
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb)
            parents[pb] = pa;
        else
            parents[pa] = pb;
    }
    static int find(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }
}
