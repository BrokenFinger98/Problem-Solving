class Solution {
    static final long MAX_N = 1_000_000_000L * 1_000_000_000L;
    static long l = 1, r = MAX_N;
    public long solution(int n, int[] times) {
        long answer = MAX_N;
        while (l <= r){
            long mid = l + (r - l) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt < n) {
                l = mid + 1;
            }else{
                r = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}