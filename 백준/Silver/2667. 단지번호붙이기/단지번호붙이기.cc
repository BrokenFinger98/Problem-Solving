#include<bits/stdc++.h>
using namespace std;
int N, cnt;
int adj[30][30];
int visited[30][30];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<int> ret;
void dfs(int y, int x){
    ++cnt;
    visited[y][x] = 1;
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
        if(adj[ny][nx] && visited[ny][nx] == 0)
            dfs(ny, nx);
    }
}
int main(){
    cin >> N;
    for(int i = 0 ; i < N; ++i){
        for(int j = 0; j < N; ++j){
            scanf("%1d", &adj[i][j]);
        }
    }
    for(int i = 0; i < N; ++i){
        for(int j = 0; j < N; ++j){
            if(adj[i][j] && visited[i][j] == 0){
                cnt = 0;
                dfs(i, j);
                ret.push_back(cnt);
            }
        }
    }
    sort(ret.begin(), ret.end());
    cout << ret.size() << "\n";
    for(auto it : ret)
        cout << it << "\n";
    return 0;
}