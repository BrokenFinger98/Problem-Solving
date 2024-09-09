import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int N, max = -1, min = 900004;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][3];
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        int[] tempMax = new int[3];
        int[] tempMin = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 3; j++) {
            maxDp[j] = input[0][j];
            minDp[j] = input[0][j];
        }

        for (int i = 1; i < N; i++) {
            tempMax[0] = Math.max(maxDp[0], maxDp[1]) + input[i][0];
            tempMax[1] = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + input[i][1];
            tempMax[2] = Math.max(maxDp[1], maxDp[2]) + input[i][2];

            tempMin[0] = Math.min(minDp[0], minDp[1]) + input[i][0];
            tempMin[1] = Math.min(minDp[0], Math.min(minDp[1], minDp[2])) + input[i][1];
            tempMin[2] = Math.min(minDp[1], minDp[2]) + input[i][2];

            System.arraycopy(tempMax, 0, maxDp, 0, 3);
            System.arraycopy(tempMin, 0, minDp, 0, 3);
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[i]);
            min = Math.min(min, minDp[i]);
        }

        System.out.println(max + " " + min);
        br.close();
    }
}
