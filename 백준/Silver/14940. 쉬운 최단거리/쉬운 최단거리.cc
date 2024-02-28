#include<bits/stdc++.h>
using namespace std;
int n, m, sy, sx, y, x;
int adj[1000][1000];
int visited[1000][1000];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;
void print(){
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cout << visited[i][j] << " ";
        }
        cout << "\n";
    }
}
void bfs(int sy, int sx){
    visited[sy][sx] = 0;
    q.push({sy, sx});
    while (q.size()){
        tie(y, x) = q.front();
        q.pop();
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(adj[ny][nx] && visited[ny][nx] == -1){
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny, nx});
            }
        }
    }
}
int main(){
    cin >> n >> m;
    memset(visited, -1, sizeof(visited));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cin >> adj[i][j];
            if(adj[i][j] == 2){
                sy = i;
                sx = j;
            }
            if(adj[i][j] == 0)
                visited[i][j] = 0;
        }
    }
    bfs(sy, sx);
    print();
}