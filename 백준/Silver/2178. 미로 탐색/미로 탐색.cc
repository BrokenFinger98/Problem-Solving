#include<bits/stdc++.h>
using namespace std;
int n, m, cnt, y, x, ny, nx;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int adj[100][100];
int visited[100][100];
queue<pair<int, int>> q;
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j)
            scanf("%1d", &adj[i][j]);
    }
    visited[0][0] = 1;
    q.push({0, 0});
    while(q.size()){
        tie(y, x) = q.front();
        q.pop();
        for(int i = 0; i <4; ++i){
            ny = y + dy[i];
            nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(adj[ny][nx] && !visited[ny][nx]){
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny, nx});
            }
        }
    }
    cout << visited[n-1][m-1] << "\n";
}