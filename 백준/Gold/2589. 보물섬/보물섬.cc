#include<bits/stdc++.h>
using namespace std;
int n, m, y, x, ny, nx, ret = 0;
char c;
int adj[50][50];
int visited[50][50];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
int bfs(int sy, int sx){
    memset(visited, 0, sizeof(visited));
    queue<pair<int, int>> q;
    int dis = 0;
    visited[sy][sx] = 1;
    q.push({sy, sx});
    while (q.size()){
        tie(y, x) = q.front();
        q.pop();
        for(int i = 0; i < 4; ++i){
            ny = y + dy[i];
            nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(adj[ny][nx] && !visited[ny][nx]){
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny, nx});
                dis = max(dis, visited[ny][nx]);
            }
        }
    }
    return dis - 1;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cin >> c;
            if(c == 'L'){
                adj[i][j] = 1;
            }
        }
    }
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            if(adj[i][j] == 1){
                ret = max(ret, bfs(i, j));
            }
        }
    }
    cout << ret << "\n";
}