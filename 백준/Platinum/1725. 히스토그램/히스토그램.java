import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  시간 : 696ms, 메모리 : 69,396KB
 */
public class Main {
    static int n;
    static long answer;
    static int[] input;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Long.MIN_VALUE;
        input = new int[n];
        tree = new int[n*4];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        init(0, n-1, 1);
        answer = getMaxArea(0, n-1);
        System.out.println(answer);
        br.close();
    }

    private static long getMaxArea(int left, int right) {
        if(left > right) return 0;
        int minIndex = query(0, n - 1, 1, left, right);

        long maxArea = (long) input[minIndex] * (right - left + 1);
        long leftArea = getMaxArea(left, minIndex - 1);
        long rightArea = getMaxArea(minIndex + 1, right);

        return Math.max(maxArea, Math.max(leftArea, rightArea));
    }

    private static int query(int start, int end, int node, int left, int right) {
        if(end < left || start > right) return -1;
        if(start >= left && end <= right) return tree[node];
        int mid = (start + end) / 2;
        int leftMinIndex = query(start, mid, node * 2, left, right);
        int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);

        if (leftMinIndex == -1) return rightMinIndex;
        if (rightMinIndex == -1) return leftMinIndex;

        return input[leftMinIndex] < input[rightMinIndex] ? leftMinIndex : rightMinIndex;
    }

    private static int init(int start, int end, int node) {
        if(start == end) return tree[node] = start;
        int mid = (start + end) / 2;
        int leftMinIndex = (int) init(start, mid, node * 2);
        int rightMinIndex = (int) init(mid + 1, end, node * 2 + 1);
        return tree[node] = input[leftMinIndex] < input[rightMinIndex] ? leftMinIndex : rightMinIndex;
    }
}