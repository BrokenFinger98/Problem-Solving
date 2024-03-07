#include<bits/stdc++.h>
using namespace std;
int N, M, K, cnt, sy, sx, ey, ex;
int adj[104][104];
int visited[104][104];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<int> ret;
void go(int sx, int sy, int ex, int ey){
    for(int i = sy; i < ey; ++i){
        for(int j = sx; j < ex; ++j)
            adj[i][j] = 0;
    }
}
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
        if(adj[ny][nx] && visited[ny][nx] == 0){
            ++cnt;
            dfs(ny, nx);
        }
    }
}
int main(){
    cin >> M >> N >> K;
    fill(&adj[0][0], &adj[0][0] + 104*104, 1);
    for(int i = 0; i < K; ++i){
        cin >> sx >> sy >> ex >> ey;
        go(sx, sy, ex, ey);
    }
    for(int i = 0; i < M; ++i){
        for(int j = 0; j < N; ++j){
            if(adj[i][j] && visited[i][j] == 0){
                ++cnt;
                dfs(i, j);
                ret.push_back(cnt);
                cnt = 0;
            }
        }
    }
    sort(ret.begin(), ret.end());
    cout << ret.size() << "\n";
    for(auto it : ret) cout << it << " ";
    cout << "\n";
}