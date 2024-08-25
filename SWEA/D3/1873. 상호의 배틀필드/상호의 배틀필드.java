import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Tank{
    int y;
    int x;

    public Tank(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Solution {
    static int T, H, W, commandCnt;
    static char command;
    static char[][] map;
    static Tank tank;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v'){
                        tank = new Tank(i, j);
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            commandCnt = Integer.parseInt(st.nextToken());
            s = br.readLine();
            for (int i = 0; i < commandCnt; i++) {
                command = s.charAt(i);
                excute();
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                if(i != 0) sb = new StringBuilder();
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                System.out.println(sb.toString());
            }
        }
        br.close();
    }
    static void excute(){
        switch (command) {
            case 'U':
                map[tank.y][tank.x] = '^';
                if(tank.y-1 < 0) break;
                if(map[tank.y-1][tank.x] == '.'){
                    map[tank.y-1][tank.x] = '^';
                    map[tank.y][tank.x] = '.';
                    tank.y--;
                }
                break;
            case 'D':
                map[tank.y][tank.x] = 'v';
                if(tank.y+1 >= H) break;
                if(map[tank.y+1][tank.x] == '.'){
                    map[tank.y+1][tank.x] = 'v';
                    map[tank.y][tank.x] = '.';
                    tank.y++;
                }
                break;
            case 'L':
                map[tank.y][tank.x] = '<';
                if(tank.x-1 < 0) break;
                if(map[tank.y][tank.x-1] == '.'){
                    map[tank.y][tank.x-1] = '<';
                    map[tank.y][tank.x] = '.';
                    tank.x--;
                }
                break;
            case 'R':
                map[tank.y][tank.x] = '>';
                if(tank.x+1 >= W) break;
                if(map[tank.y][tank.x+1] == '.'){
                    map[tank.y][tank.x+1] = '>';
                    map[tank.y][tank.x] = '.';
                    tank.x++;
                }
                break;
            case 'S':
                char direction = map[tank.y][tank.x];
                boolean flag = false;
                int ny = tank.y;
                int nx = tank.x;
                int dy = 0;
                int dx = 0;
                if(direction == '^'){
                    dy = -1;
                }else if(direction == 'v'){
                    dy = 1;
                }else if(direction == '>'){
                    dx = 1;
                } else if (direction == '<') {
                    dx = -1;
                }
                do {
                    ny += dy;
                    nx += dx;
                    if(ny < 0 || ny >= H || nx < 0 || nx >= W){
                        flag = true;
                        break;
                    }
                }while (map[ny][nx] == '.' || map[ny][nx] == '-');
                if(flag) break;
                if(map[ny][nx] == '*') map[ny][nx] = '.';
                break;
            default:
                break;
        }
    }
}
