import java.lang.*;
import java.util.*;

class Solution {
    static boolean[][] map = new boolean[104][104];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;
    static int n, m, sy, sx, ey, ex, ly, lx;
    static Queue<int[]> queue;
    public int solution(String[] maps) {
        init(maps);
        
        int result1 = bfsToLever();
        // print();
        if(result1 == 0) return -1;
        
        int result2 = bfsToExit(); 
        // print();
        if(result2 == 0) return -1;

        return result1 + result2;
    }
    
    private void init(String[] maps){
        n = maps.length;
        m = maps[0].length();
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j){
                char c = maps[i].charAt(j);
                map[i][j] = true;
                if(c == 'S'){
                    sy = i;
                    sx = j;
                } else if(c == 'L') {
                    ly = i;
                    lx = j;
                } else if(c == 'E') {
                    ey = i;
                    ex = j;
                } else if(c == 'X'){
                    map[i][j] = false;
                }
            }
        }
    }
    
    private int bfsToLever(){
        visited = new int[n][m];
        queue = new ArrayDeque<>();
        queue.offer(new int[]{sy, sx});
        visited[sy][sx] = 1;
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            if(position[0] == ly && position[1] == lx){
                return visited[ly][lx] - 1;
            }
            for(int i = 0; i < 4; ++i){
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[position[0]][position[1]] + 1;
                    queue.offer(new int[]{ny, nx});   
                }
            }
        }
        return 0;
    }
    
    private int bfsToExit(){
        visited = new int[n][m];
        queue = new ArrayDeque<>();
        queue.offer(new int[]{ly, lx});
        visited[ly][lx] = 1;
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            if(position[0] == ey && position[1] == ex){
                return visited[ey][ex] - 1;
            }
            for(int i = 0; i < 4; ++i){
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[position[0]][position[1]] + 1;
                    queue.offer(new int[]{ny, nx});   
                }
            }
        }
        return 0;
    }
    
    private void print(){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("====================");
    }
}