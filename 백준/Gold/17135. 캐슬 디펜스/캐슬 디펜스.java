import java.io.*;
import java.lang.*;
import java.util.*;

class Enemy implements Comparable<Enemy>{
    int y;
    int x;
    int distance;
    public Enemy(int y, int x, int distance){
        this.y = y;
        this.x = x;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enemy enemy = (Enemy) o;
        return y == enemy.y && x == enemy.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    @Override
    public int compareTo(Enemy o) {
        if(this.distance == o.distance) return this.x - o.x;
        return this.distance - o.distance;
    }
}
public class Main {
    static int N, M, result, distance;
    static int[][] map;
    static int[] index = new int[3];
    static Set<Enemy> enemies;
    static PriorityQueue<Enemy> priorityQueue;
//    static Enemy[] enemies = new Enemy[3];
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        temp = new int[N][M];

        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(result);
        br.close();
    }

    static void combi(int depth, int start){
        if(depth == 3){
            result = Math.max(result, checkResult());
            return;
        }

        for(int i = start; i < M; ++i){
            index[depth] = i;
            combi(depth+1, i+1);
        }
    }

    static int checkResult(){
        temp = new int[N][M];
        for(int i = 0; i < N; ++i){
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        int sum = 0;
        int cnt = 0;
        while (cnt < N){
            enemies = new HashSet<>();
            for(int archer = 0; archer < index.length; ++archer){
                priorityQueue = new PriorityQueue<>();
                Enemy enemy = new Enemy(-1, -1, 0);
                for(int i = N-1; i > -1; --i){
                    for(int j = 0; j < M; ++j){
                        if(temp[i][j] == 1){
                            int dis = Math.abs(N-i) + Math.abs(j - index[archer]);
                            priorityQueue.offer(new Enemy(i, j, dis));
                        }
                    }
                }
                if(!priorityQueue.isEmpty() && priorityQueue.peek().distance <= distance){
                    enemies.add(priorityQueue.poll());
                }
            }

            Iterator<Enemy> iterator = enemies.iterator();
            while (iterator.hasNext()){
                Enemy enemy = iterator.next();
                temp[enemy.y][enemy.x] = 0;
                ++sum;
            }

            for(int i = N-2; i > -1; --i){
                for(int j = 0; j < M; ++j){
                    temp[i+1][j] = temp[i][j];
                }
            }
            for(int j = 0; j < M; ++j){
                temp[0][j] = 0;
            }

            ++cnt;
        }

        return sum;
    }
}
