#include<bits/stdc++.h>
using namespace std;
int n, m, cnt1, cnt2;
int adj[100][100];
int visited[100][100];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
vector<pair<int, int>> v;
void go(int y, int x){
    visited[y][x] = 1;
    if(adj[y][x] == 1){
        v.push_back({y,x});
        return;
    }
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
        go(ny, nx);
    }
    return;
}
int main(){
    cin >> n >> m;
    for(int i = 0;i < n; ++i){
        for(int j = 0; j < m; ++j)
            cin >> adj[i][j];
    }
    while (true){
        cnt2 = 0;
        fill(&visited[0][0], &visited[100][100], 0);
        v.clear();
        go(0, 0);
        for(pair<int, int> b : v){
            cnt2++;
            adj[b.first][b.second] = 0;
        }
        bool flag = 0;
        for(int i = 0;i < n; ++i){
            for(int j = 0; j < m; ++j)
                if(adj[i][j] == 1) flag = 1;
        }
        cnt1++;
        if(!flag) break;
    }
    cout << cnt1 << "\n" << cnt2 << "\n";
}