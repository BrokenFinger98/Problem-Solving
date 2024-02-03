#include<bits/stdc++.h>
using namespace std;
const int maxN = 104;
int maxE;
int N;
int ret[maxN];
int adj[maxN][maxN];
int visited[maxN][maxN];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int h, int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
        if(adj[ny][nx] > h && visited[ny][nx] == 0)
            dfs(h, ny, nx);
    }
    return;
}
int main(){
    cin >> N;
    for(int i = 0; i<N; ++i){
        for(int j = 0; j<N;++j){
            cin >> adj[i][j];
            maxE = max(maxE, adj[i][j]);
        }
    }
    for(int i = 0; i < maxE ;++i){
        memset(visited, 0, sizeof(visited));
        for(int j = 0; j < N; ++j){
            for(int k = 0; k < N; ++k){
                if(adj[j][k] > i && visited[j][k] == 0){
                    ret[i]++;
                    dfs(i, j, k);
                }
            }
        }
    }
    cout << *max_element(ret, ret + maxN) << "\n";
    return 0;
}