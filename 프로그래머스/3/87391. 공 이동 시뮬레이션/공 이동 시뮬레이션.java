class Solution {
    public long solution(int n, int m, int y, int x, int[][] queries) {
        long rL = y, rR = y;   // row interval [rL, rR]
        long cL = x, cR = x;   // col interval [cL, cR]

        for (int i = queries.length - 1; i >= 0; --i) {
            int d = queries[i][0];
            int s = queries[i][1];

            if (d == 0) { // left: x = max(0, x - s)
                // 역방향: 오른쪽으로 s만큼 확장. 다만 0에 붙어있던 하한은 그대로 0 유지
                if (cL != 0) cL += s;
                cR = Math.min(m - 1L, cR + s);
            } else if (d == 1) { // right: x = min(m-1, x + s)
                // 역방향: 왼쪽으로 s만큼 이동. 상한이 m-1에 붙어있던 경우는 그대로 고정
                if (cR != m - 1L) cR -= s;
                cL = Math.max(0L, cL - s);
            } else if (d == 2) { // up: y = max(0, y - s)
                if (rL != 0) rL += s;
                rR = Math.min(n - 1L, rR + s);
            } else { // d == 3, down: y = min(n-1, y + s)
                if (rR != n - 1L) rR -= s;
                rL = Math.max(0L, rL - s);
            }

            // 구간이 깨지면 불가능
            if (rL > rR || cL > cR) return 0L;
            // 따로 추가 클리핑은 필요 없음 (위 조건으로 충분)
        }

        return (rR - rL + 1) * (cR - cL + 1);
    }
}