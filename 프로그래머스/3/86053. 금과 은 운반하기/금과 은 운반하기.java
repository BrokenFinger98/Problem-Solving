import java.util.*;

/*
도시의 개수 = 100,000(10만)
금, 은의 최대 무게 = 10억

1. 완탐으로 가능한가?
2. dp로 가능한가?
3. greedy로 가능한가?
최대 result = (10억 - 1) * 10만 * 2 + 10만
이분 탐색?
*/
class Solution {
    private static long MAX_RESULT = 4_000_000_000_000_000L;

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = MAX_RESULT;
        long answer = MAX_RESULT;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canCarry(mid, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    boolean canCarry(long timeLimit, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalWeight = 0;

        for (int i = 0; i < g.length; i++) {
            long moveCount = timeLimit / (2L * t[i]);
            if (timeLimit % (2L * t[i]) >= t[i]) {
                moveCount++;
            }

            long maxTransport = moveCount * w[i];

            long goldCanMove = Math.min(g[i], maxTransport);
            long silverCanMove = Math.min(s[i], maxTransport);
            long totalCanMove = Math.min(g[i] + s[i], maxTransport);

            totalGold += goldCanMove;
            totalSilver += silverCanMove;
            totalWeight += totalCanMove;
        }

        return totalGold >= a && totalSilver >= b && totalWeight >= (a + b);
    }
}