import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 : 832ms, 메모리 : 129,820KB
 */
public class Main {
    static int N, M, K;
    static int answer = Integer.MAX_VALUE;
    static int[][] prefixWhite;
    static int[][] prefixBlack;
    static char[][] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefixWhite = new int[N + 1][M + 1];
        prefixBlack = new int[N + 1][M + 1];
        chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            chessBoard[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean shouldBeWhite = ((i + j) % 2 == 0);
                prefixWhite[i + 1][j + 1] = prefixWhite[i][j + 1] + prefixWhite[i + 1][j] - prefixWhite[i][j] + (chessBoard[i][j] == (shouldBeWhite ? 'W' : 'B') ? 0 : 1);
                prefixBlack[i + 1][j + 1] = prefixBlack[i][j + 1] + prefixBlack[i + 1][j] - prefixBlack[i][j] + (chessBoard[i][j] == (shouldBeWhite ? 'B' : 'W') ? 0 : 1);
            }
        }

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int countWhite = prefixWhite[i][j] - prefixWhite[i - K][j] - prefixWhite[i][j - K] + prefixWhite[i - K][j - K];
                int countBlack = prefixBlack[i][j] - prefixBlack[i - K][j] - prefixBlack[i][j - K] + prefixBlack[i - K][j - K];
                answer = Math.min(answer, Math.min(countWhite, countBlack));
            }
        }

        System.out.println(answer);
        br.close();
    }
}
