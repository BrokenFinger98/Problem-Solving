#include<bits/stdc++.h>
using namespace std;
int n, y, x, h, max_h, cnt, ret;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int adj[100][100];
int visited[100][100];
void dfs(int y, int x, int h){
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
        if(adj[ny][nx] > h && !visited[ny][nx]){
            visited[ny][nx] = 1;
            dfs(ny, nx, h);
        } 
    }
}
int main(){
    cin >> n;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> adj[i][j];
            if(adj[i][j] > max_h) max_h = adj[i][j];
        }
    }
    for(int i = 0; i < max_h; ++i){
        memset(visited, 0, sizeof(visited));
        cnt = 0;
        for(int j = 0; j < n; ++j){
            for(int k = 0; k < n; ++k){
                if(adj[j][k] > i && !visited[j][k]){
                    ++cnt;
                    dfs(j, k, i);
                }
            }
        }
        ret = max(cnt, ret);
    }
    cout << ret << "\n";
}