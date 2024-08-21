import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int key = arr[i];
            int left = 0;
            int right = N-1;
            while (left < right){
                if(left == i){
                    left++;
                    continue;
                }
                if(right == i){
                    --right;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(sum == key){
                    ++result;
                    break;
                } else if (sum < key) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        System.out.println(result);
    }
}
