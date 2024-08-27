import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Shark implements Comparable<Shark>{
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return o.z - this.z;
        }
    }
    static int R, C, M;
    static int r, c, s, d, z, sum;
    static Shark[][] map;
    static PriorityQueue<Shark> pq = new PriorityQueue<>();
    static PriorityQueue<Shark> newPq;
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R+1][C+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            pq.offer(shark);
            map[r][c] = shark;
        }

        for (int cnt = 1; cnt <= C; cnt++) {
            for (int i = 1; i <= R; i++) {
                if(map[i][cnt] != null){
                    sum += map[i][cnt].z;
                    pq.remove(map[i][cnt]);
                    break;
                }
            }

            map = new Shark[R+1][C+1];
            newPq = new PriorityQueue<>();

            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Shark shark = pq.poll();
                move(shark);
            }
            pq = newPq;
        }
        System.out.println(sum);
    }
    static void move(Shark shark) {
        int r = shark.r;
        int c = shark.c;
        int s = shark.s;
        int d = shark.d;
        
        if (d == 1 || d == 2) {
            s = s % (2 * (R - 1));
        } else { 
            s = s % (2 * (C - 1));
        }

        for (int i = 0; i < s; i++) {
            if (d == 1 && r == 1) d = 2; 
            else if (d == 2 && r == R) d = 1; 
            else if (d == 4 && c == 1) d = 3; 
            else if (d == 3 && c == C) d = 4; 

            r += dy[d];
            c += dx[d];
        }

        shark.r = r;
        shark.c = c;
        shark.d = d;

        if (map[r][c] == null) {
            map[r][c] = shark;
            newPq.offer(shark);
        }
    }
}

