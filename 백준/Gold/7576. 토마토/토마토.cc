#include<bits/stdc++.h>
using namespace std;
int N, M, y, x, ret, e;
int adj[1004][1004];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;
int main(){
    cin >> M >> N;
    for(int i = 0; i < N; ++i){
        for(int j = 0; j < M; ++j){
            cin >> adj[i][j];
            if(adj[i][j] == 1) q.push({i, j});
        }
    }
    while(q.size()){
        tie(y, x) = q.front();
        q.pop();
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if(adj[ny][nx] == 0){
                adj[ny][nx] = adj[y][x] + 1;
                q.push({ny, nx});
            }
        }
    }
    for(int i = 0; i < N; ++i){
        for(int j = 0; j < M; ++j){
            if(adj[i][j] == 0){
                cout << -1 <<"\n";
                return 0;
            }
            if(ret < adj[i][j]) ret = adj[i][j];
        }
    }
    cout << ret-1 << "\n";
    return 0;
}