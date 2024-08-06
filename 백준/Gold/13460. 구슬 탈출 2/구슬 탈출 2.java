import java.io.*;
import java.lang.*;
import java.util.*;

class Pair {
    int blue_y;
    int blue_x;
    int red_y;
    int red_x;
    int cnt;

    public Pair(int blue_y, int blue_x, int red_y, int red_x, int cnt) {
        this.blue_y = blue_y;
        this.blue_x = blue_x;
        this.red_y = red_y;
        this.red_x = red_x;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M;
    static int by, bx, ry, rx, nby, nbx, nry, nrx;
    static char[][] mp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mp = new char[N][M];

        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            for (int j = 0; j < M; ++j) {
                mp[i][j] = str.charAt(j);
                if (mp[i][j] == 'B') {
                    by = i;
                    bx = j;
                    mp[i][j] = '.';
                } else if (mp[i][j] == 'R') {
                    ry = i;
                    rx = j;
                    mp[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(by, bx, ry, rx, 0));
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (now.cnt == 10) {
                continue;
            }
            for (int j = 0; j < 4; ++j) {
                by = now.blue_y;
                bx = now.blue_x;
                ry = now.red_y;
                rx = now.red_x;
                boolean flag_b = false;
                boolean flag_r = false;

                while (true) {
                    int nby = by + dy[j];
                    int nbx = bx + dx[j];
                    if (mp[nby][nbx] == '#') break;
                    if (mp[nby][nbx] == 'O') {
                        flag_b = true;
                        break;
                    }
                    by = nby;
                    bx = nbx;
                }
                while (true) {
                    int nry = ry + dy[j];
                    int nrx = rx + dx[j];
                    if (mp[nry][nrx] == '#') break;
                    if (mp[nry][nrx] == 'O') {
                        flag_r = true;
                        break;
                    }
                    ry = nry;
                    rx = nrx;
                }
                if (flag_b) {
                    continue;
                } else if (flag_r) {
                    return now.cnt + 1;
                }
                if (now.blue_y == by && now.blue_x == bx && now.red_y == ry && now.red_x == rx) continue;

                if (ry == by && rx == bx) {
                    if (j == 0) {
                        if (now.blue_y > now.red_y) {
                            ry--;
                        } else {
                            by--;
                        }
                    } else if (j == 1) {
                        if (now.blue_x > now.red_x) {
                            rx--;
                        } else {
                            bx--;
                        }
                    } else if (j == 2) {
                        if (now.blue_y > now.red_y) {
                            by++;
                        } else {
                            ry++;
                        }
                    } else {
                        if (now.blue_x > now.red_x) {
                            bx++;
                        } else {
                            rx++;
                        }
                    }
                }
                queue.offer(new Pair(by, bx, ry, rx, now.cnt + 1));
            }
        }
        return -1;
    }
}