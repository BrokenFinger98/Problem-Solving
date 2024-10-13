import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int T, N, W, H, answer;
    static int[][] map, initMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            initMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    initMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] arr = new int[N];
            answer = Integer.MAX_VALUE;
            permutation(arr, 0);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void fallingBricks(){
        for (int j = 0; j < W; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = H-1; i >= 0; --i) {
                if(map[i][j] != 0) {
                    list.add(map[i][j]);
                    map[i][j] = 0;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                map[H-1-i][j] = list.get(i);
            }
        }
    }

    static int calculateBricks() {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] != 0) ++cnt;
            }
        }
        return cnt;
    }

    static void breakBrick(int y, int x){
        int power = map[y][x];
        map[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < power; j++) {
                int ny = y + dy[i] * j;
                int nx = x + dx[i] * j;
                if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if(map[ny][nx] != 0) breakBrick(ny, nx);
            }
        }
    }

    static void permutation(int[] arr, int depth){
        if(depth == N){
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = initMap[i][j];
                }
            }
            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                int y = 0;
                for (int j = 0; j < H; j++) {
                    if(map[j][x] != 0){
                        y = j;
                        break;
                    }
                }
                breakBrick(y, x);
                fallingBricks();
            }
            answer = Math.min(answer, calculateBricks());
//            System.out.println("----------------------------");
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < W; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("----------------------------");
            return;
        }
        for (int i = 0; i < W; i++) {
            arr[depth] = i;
            permutation(arr, depth+1);
        }
    }
}
/*
1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
 */