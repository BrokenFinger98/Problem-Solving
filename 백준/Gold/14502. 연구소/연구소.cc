#include<bits/stdc++.h>
using namespace std;
int n, m, ret;
int adj[8][8];
int visited[8][8];
vector<pair<int, int>> virusList, wallList;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int y, int x){
    for(int i =0;i<4;++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if(adj[ny][nx] == 0 && visited[ny][nx] == 0){
            visited[ny][nx] = 1;
            dfs(ny, nx); 
        }
    }
}
int solve(){
    memset(visited, 0, sizeof(visited));
    for(pair<int, int> it : virusList){
        visited[it.first][it.second] = 1;
        dfs(it.first, it.second);
    }
    int cnt = 0;
    for(int  i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            if(adj[i][j] == 0 && visited[i][j] == 0)
                ++cnt;
        }
    }
    return cnt;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int ret = 0;
    cin >> n >> m;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cin >> adj[i][j];
            if(adj[i][j] == 2) virusList.push_back({i, j});
            if(adj[i][j] == 0) wallList.push_back({i, j});
        }
    }
    for(int i = 0; i < wallList.size(); ++i){
        for(int j = i+1; j < wallList.size(); ++j){
            for(int k = j+1; k < wallList.size(); ++k){
                adj[wallList[i].first][wallList[i].second] = 1;
                adj[wallList[j].first][wallList[j].second] = 1;
                adj[wallList[k].first][wallList[k].second] = 1;
                ret = max(ret, solve());
                adj[wallList[i].first][wallList[i].second] = 0;
                adj[wallList[j].first][wallList[j].second] = 0;
                adj[wallList[k].first][wallList[k].second] = 0;
            }
        }
    }
    cout << ret << "\n";
    return 0;
}