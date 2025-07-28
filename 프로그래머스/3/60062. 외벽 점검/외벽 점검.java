import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int length;

    public int solution(int n, int[] weak, int[] dist) {
        length = weak.length;

        int[] linearWeak = new int[length * 2];
        for (int i = 0; i < length * 2; i++) {
            if (i < length) linearWeak[i] = weak[i];
            else linearWeak[i] = weak[i - length] + n;
        }

        List<int[]> permutations = new ArrayList<>();
        permute(dist, 0, permutations);

        for (int start = 0; start < length; start++) {
            for (int[] friends : permutations) {
                int count = 1;
                int position = linearWeak[start] + friends[0];

                for (int i = start; i < start + length; i++) {
                    if (linearWeak[i] > position) {
                        count++;
                        if (count > dist.length) {
                            count = Integer.MAX_VALUE;
                            break;
                        }
                        position = linearWeak[i] + friends[count - 1];
                    }
                }
                answer = Math.min(answer, count);
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    void permute(int[] dist, int depth, List<int[]> result) {
        if (depth == dist.length) {
            result.add(dist.clone());
            return;
        }
        
        for (int i = depth; i < dist.length; i++) {
            swap(dist, i, depth);
            permute(dist, depth + 1, result);
            swap(dist, i, depth);
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}