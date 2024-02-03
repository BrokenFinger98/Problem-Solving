#include<bits/stdc++.h>
using namespace std;
int T, N, M, K, y, x, cnt;
int adj[54][54];
int visited[54][54];
int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};
void dfs(int sy, int sx){
    visited[sy][sx] = 1;
    for(int i = 0; i < 4; ++i){
        int ny = sy + dy[i];
        int nx = sx + dx[i];
        if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if(adj[ny][nx] == 1 && !visited[ny][nx]) 
            dfs(ny,nx);
    }
    return;
}
int main(){
    cin >> T;
    for(int i = 0; i < T; ++i){
        cin >> M >> N >> K;
        memset(adj, 0, sizeof(adj));
        memset(visited, 0, sizeof(visited));
        cnt = 0;
        for(int j = 0; j < K; ++j){
            cin >> x >> y;
            adj[y][x] = 1;
        }
        for(int j = 0; j < N; ++j){
            for(int k = 0; k < M; ++k){
                if(adj[j][k] && visited[j][k] == 0){
                    ++cnt;
                    dfs(j, k);
                }
            }
        }
        cout << cnt << "\n";
    }
}