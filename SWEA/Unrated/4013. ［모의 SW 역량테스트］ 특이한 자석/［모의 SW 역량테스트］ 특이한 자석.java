import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] magnets; // 자석 상태 저장 (4개 자석 각각 8개 날)
    static int K; // 회전 횟수
    static int[] directions; // 자석 회전 방향 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine()); // 회전 횟수
            magnets = new int[4][8]; // 4개의 자석, 8개의 날

            // 자석 상태 입력
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // K번 회전 명령 처리
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int magnetIdx = Integer.parseInt(st.nextToken()) - 1; // 회전시킬 자석 (0부터 시작)
                int dir = Integer.parseInt(st.nextToken()); // 회전 방향 (1: 시계, -1: 반시계)

                // 자석 회전 처리
                rotate(magnetIdx, dir);
            }

            // 최종 점수 계산
            int score = calculateScore();
            sb.append("#").append(t).append(" ").append(score).append("\n");
        }
        System.out.println(sb);
    }

    // 자석 회전 처리
    static void rotate(int idx, int dir) {
        directions = new int[4]; // 각 자석의 회전 방향 저장
        directions[idx] = dir; // 현재 자석은 주어진 방향으로 회전

        // 왼쪽 자석 확인
        for (int i = idx - 1; i >= 0; i--) {
            if (magnets[i][2] != magnets[i + 1][6]) { // 서로 다른 자성이면
                directions[i] = -directions[i + 1]; // 반대 방향으로 회전
            } else {
                break;
            }
        }

        // 오른쪽 자석 확인
        for (int i = idx + 1; i < 4; i++) {
            if (magnets[i - 1][2] != magnets[i][6]) { // 서로 다른 자성이면
                directions[i] = -directions[i - 1]; // 반대 방향으로 회전
            } else {
                break;
            }
        }

        // 실제로 자석 회전
        for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
                performRotation(i, directions[i]);
            }
        }
    }

    // 자석의 실제 회전 처리
    static void performRotation(int idx, int dir) {
        if (dir == 1) { // 시계 방향 회전
            int temp = magnets[idx][7];
            for (int i = 7; i > 0; i--) {
                magnets[idx][i] = magnets[idx][i - 1];
            }
            magnets[idx][0] = temp;
        } else { // 반시계 방향 회전
            int temp = magnets[idx][0];
            for (int i = 0; i < 7; i++) {
                magnets[idx][i] = magnets[idx][i + 1];
            }
            magnets[idx][7] = temp;
        }
    }

    // 점수 계산
    static int calculateScore() {
        int score = 0;
        if (magnets[0][0] == 1) score += 1; // 1번 자석
        if (magnets[1][0] == 1) score += 2; // 2번 자석
        if (magnets[2][0] == 1) score += 4; // 3번 자석
        if (magnets[3][0] == 1) score += 8; // 4번 자석
        return score;
    }
}
