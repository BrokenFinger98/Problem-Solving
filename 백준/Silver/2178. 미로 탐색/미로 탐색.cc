#include<bits/stdc++.h>
using namespace std;
int N, M, x, y;
int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};
int adj[104][104];
int visited[104][104];
queue<pair<int, int>> q;
void bfs(int sy, int sx){
    visited[sy][sx] = 1;
    q.push({sy,sx});
    while (q.size()){
        tie(y, x) = q.front(); q.pop();
        for(int i =0;i<4;++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >=N || nx < 0 || nx >= M || adj[ny][nx] == 0) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny, nx});
        }
    }
    return;
}
int main(){
    cin >> N >> M;
    for(int i = 0;i<N;++i){
        for(int j=0;j<M;++j)
            scanf("%1d", &adj[i][j]);
    }
    bfs(0, 0);
    cout << visited[N-1][M-1] << "\n";
    return 0;
}