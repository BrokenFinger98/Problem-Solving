#include<bits/stdc++.h>
using namespace std; 
int n, m, y, x, ret = INT_MIN;
char a[50][50];
int visited[50][50];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
vector<pair<int, int>> v;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cin >> a[i][j];
            if(a[i][j] == 'L')
                v.push_back({i, j});
        }
    }

    for(pair<int, int> b : v){
        memset(visited, 0, sizeof(visited));
        int sy = b.first;
        int sx = b.second;
        visited[sy][sx] = 1;
        queue<pair<int, int>> q;
        q.push({sy, sx});
        int cnt = 0;
        while (q.size()){
            tie(y, x) = q.front();
            q.pop();
            for(int i = 0; i < 4; ++i){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
                if(a[ny][nx] == 'L'){
                    visited[ny][nx] = visited[y][x] + 1;
                    cnt = max(cnt, visited[ny][nx]);
                    q.push({ny, nx});
                }
            }
        }
        ret = max(ret, cnt-1);
    }
    cout << ret << "\n";
    return 0;
}