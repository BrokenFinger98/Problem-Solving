#include<bits/stdc++.h>
using namespace std;
int n, m, cnt, sy, sx, y, x;
string s;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;
char adj[604][604];
int visited[604][604];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cin >> adj[i][j];
            if(adj[i][j] == 'X')
                visited[i][j] = 1;
            if(adj[i][j] == 'I'){
                sy = i;
                sx = j;
            }
        }
    }
    visited[sy][sx] = 1;
    q.push({sy, sx});
    while (q.size()){
        tie(y,x) = q.front();
        q.pop();
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(visited[ny][nx] == 0){
                if(adj[ny][nx] == 'P') ++cnt;
                visited[ny][nx] = 1;
                q.push({ny, nx});
            }
        }
    }
    if(cnt == 0) cout << "TT" << "\n";
    else cout << cnt << "\n";
    return 0;
}