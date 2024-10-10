import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair{
        int y, x;
        boolean status;

        public Pair(int y, int x, boolean status) {
            this.y = y;
            this.x = x;
            this.status = status;
        }
    }

	static int R, C, answer;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static Pair go;
    static Queue<Pair> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '*'){
                    queue.offer(new Pair(i, j, false));
                }else if(map[i][j] == 'S'){
                    go = new Pair(i, j, true);
                }
            }
        }

        queue.offer(go);
        while (!queue.isEmpty()){
            int size = queue.size();
            ++answer;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int y = pair.y;
                int x = pair.x;
                boolean status = pair.status;
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if(!status && map[ny][nx] == '.'){
                        map[ny][nx] = '*';
                        queue.offer(new Pair(ny, nx, false));
                    }else if(status && map[ny][nx] == '.') {
                        map[ny][nx] = 'S';
                        queue.offer(new Pair(ny, nx, true));
                    }else if(status && map[ny][nx] == 'D') {
                        System.out.println(answer);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println("KAKTUS");
        br.close();
    }
}
