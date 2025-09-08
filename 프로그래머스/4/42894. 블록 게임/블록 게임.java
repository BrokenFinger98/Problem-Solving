import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;

        boolean removed;
        do {
            removed = false;
            // 전체 보드를 순회하며 2x3 / 3x2 두 형태를 모두 시도
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {

                    // 2x3 직사각형 시도
                    if (y + 1 < n && x + 2 < n) {
                        if (tryRemove(board, y, x, 2, 3)) {
                            answer++;
                            removed = true;
                        }
                    }

                    // 3x2 직사각형 시도
                    if (y + 2 < n && x + 1 < n) {
                        if (tryRemove(board, y, x, 3, 2)) {
                            answer++;
                            removed = true;
                        }
                    }
                }
            }
        } while (removed);

        return answer;
    }

    // (y, x)를 왼쪽 위로 하는 h x w 직사각형에서 제거를 시도
    private boolean tryRemove(int[][] board, int y, int x, int h, int w) {
        int n = board.length;

        int zeroCount = 0;
        Integer blockValue = null; // 직사각형 내 유일한 블록 값(0 제외)
        int blockCount = 0;

        // 빈칸 좌표(위가 뚫려 있어야 하는 칸) 기록
        List<int[]> zeros = new ArrayList<>();
        // 실제로 제거할 블록 좌표(같은 숫자 4칸)
        List<int[]> blocks = new ArrayList<>();

        // 직사각형 내부 검사
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int r = y + i;
                int c = x + j;
                int val = board[r][c];

                if (val == 0) {
                    zeroCount++;
                    zeros.add(new int[]{r, c});
                } else {
                    // 블록 값이 하나로만 구성되어야 함
                    if (blockValue == null) blockValue = val;
                    else if (blockValue != val) return false; // 서로 다른 값 섞임 -> 제거 불가

                    blockCount++;
                    blocks.add(new int[]{r, c});
                }
            }
        }

        // 정확히 2개의 빈칸 + 같은 숫자 4개가 아니면 불가
        if (zeroCount != 2 || blockCount != 4) return false;

        // 빈칸 2칸의 "위쪽"이 모두 뚫려 있어야 함 (해당 칸 위로 0이 아닌 값이 없어야 함)
        for (int[] z : zeros) {
            int zr = z[0], zc = z[1];
            for (int r = 0; r < zr; r++) {
                if (board[r][zc] != 0) return false; // 위가 막혀 있음
            }
        }

        // 제거 수행: 같은 숫자 4칸을 0으로
        for (int[] b : blocks) {
            board[b[0]][b[1]] = 0;
        }
        return true;
    }
}