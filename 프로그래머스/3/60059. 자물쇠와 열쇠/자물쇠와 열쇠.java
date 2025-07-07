class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int mapSize = N + (M - 1) * 2;
        int offset = M - 1;

        for (int rot = 0; rot < 4; rot++) {
            key = rotate(key);

            for (int x = 0; x <= mapSize - M; x++) {
                for (int y = 0; y <= mapSize - M; y++) {
                    int[][] map = new int[mapSize][mapSize];

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            map[i + offset][j + offset] = lock[i][j];
                        }
                    }

                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            map[x + i][y + j] += key[i][j];
                        }
                    }

                    if (check(map, offset, N)) return true;
                }
            }
        }

        return false;
    }

    private int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    private boolean check(int[][] map, int offset, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i + offset][j + offset] != 1) return false;
            }
        }
        return true;
    }
}