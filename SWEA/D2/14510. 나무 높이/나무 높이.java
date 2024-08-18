import java.io.*;
import java.util.*;
import java.lang.*;

/**
 *  시간 : 110ms, 메모리 : 18424KB
 */
public class Solution {
    static int T, N, result, maxHeight, height;
    static int[] trees = new int[104];
    static int oddCount, evenCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; ++t){
            sb = new StringBuilder();
            result = 0;
            maxHeight = 0;
            N = Integer.parseInt(br.readLine());
            trees = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; ++i){
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(trees[i], maxHeight);
            }
            for (int i = 0; i < N; i++) {
                if(trees[i] == maxHeight) continue;
                height = maxHeight - trees[i];
                if(height % 2 == 0){
                    evenCount += height/2;
                }else{
                    oddCount++;
                    evenCount += (height-1)/2;
                }
            }

            while (evenCount != 0 || oddCount != 0){
                ++result;
                if(result % 2 == 0){
                    if(evenCount != 0){
                        evenCount--;
                    }
                }else{
                    if(oddCount == 0){
                        if(evenCount > 1){
                            evenCount--;
                            oddCount++;
                        }
                    }else{
                        oddCount--;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb.toString());
        }
        br.close();
    }
}
