#include<bits/stdc++.h>
using namespace std;
int n, cntR, cntB, cntG, cntRG;
char adj[100][100];
int visited[100][100];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int y, int x, char c){
    visited[y][x] = 1;
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
        if(adj[ny][nx] == c && visited[ny][nx] == 0)
            dfs(ny, nx, c);
    }
}
int main(){
    cin >> n;
    for(int i = 0; i < n ; ++i){
        getchar();
        for(int j = 0; j < n; ++j){
            scanf("%c", &adj[i][j]);
        }
    }
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(adj[i][j] == 'B' && visited[i][j] == 0){
                ++cntB;
                dfs(i, j, 'B');
            }
        }
    }
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(adj[i][j] == 'R' && visited[i][j] == 0){
                ++cntR;
                dfs(i, j, 'R');
            }
        }
    }
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(adj[i][j] == 'G' && visited[i][j] == 0){
                ++cntG;
                dfs(i, j, 'G');
            }
        }
    }
    for(int i = 0; i < n; ++i)
        for(int j = 0; j < n; ++j)
            if(adj[i][j] == 'G')
                adj[i][j] = 'R';
    memset(visited, 0, sizeof(visited));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(adj[i][j] == 'R' && visited[i][j] == 0){
                ++cntRG;
                dfs(i, j, 'R');
            }
        }
    }
    cout << cntB+cntR+cntG << " " << cntB+cntRG << "\n";
}